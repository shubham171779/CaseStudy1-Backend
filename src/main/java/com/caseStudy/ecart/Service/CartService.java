package com.caseStudy.ecart.Service;

import com.caseStudy.ecart.Repository.*;
import com.caseStudy.ecart.modal.Users;
import com.caseStudy.ecart.modal.cart;
import com.caseStudy.ecart.modal.items;
import com.caseStudy.ecart.modal.orders;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SimpleRepository simpleRepository;
    @Autowired
    OrderRepository orderRepository;

    ItemRepositoryClass itemRepositoryClass;
    private Object Users;

    private ArrayList<cart> getCartFrontUser(Principal principal) {
        Optional<Users> users = userRepository.findByEmail(principal.getName());
        ArrayList<cart> car = cartRepository.findAllByUsers(users);
        return car;
    }
    public ArrayList<cart> getEmail(Principal principal) {
        String email = principal.getName();
        Optional<Users> users= userRepository.findByEmail(email);
        return cartRepository.findAllByUsers(users);
    }
    public String additemstoCart(Principal principal, Long id) {
        Optional<items> item = simpleRepository.findById(id);
        Optional<Users> users = userRepository.findByEmail(principal.getName());
        ArrayList<cart> cart = getCartFrontUser(principal);
        for(int i = 0; i<cart.size(); i++)
        {
            cart cartObj = cart.get(i);
            if(cartObj.getItm() == item.get())
            {
                cartObj.setQuantity(cartObj.getQuantity() + 1);
                cartRepository.save(cartObj);
                return "\"Quantity++\"";
            }
        }
        cart cartObj = new cart();
        cartObj.setQuantity(1);
        cartObj.setItm(item.get());
        cartObj.setUsr(users.get());
        cartRepository.save(cartObj);
        return "\"Item added\"";
    }
    @Transactional
    public String deleteItemFromCart(Long id, Principal principal)
    {
        Optional<items> items = simpleRepository.findById(id);
        Optional<Users> users = userRepository.findByEmail(principal.getName());
        cartRepository.deleteByUsersAndItems(users,items);
        return "\"deletion completed\"";
    }
    public String increment(int value, Long productId, Principal principal)
    {
        ArrayList<cart> carts = getCartFrontUser(principal);
        Optional<items> items=simpleRepository.findById(productId);
        for(int i=0 ; i<carts.size() ; i++)
        {
            cart cartObj = carts.get(i);
            if(cartObj.getItm() == items.get())
            {
                cartObj.setQuantity(cartObj.getQuantity() + value);
                cartRepository.save(cartObj);
                return "\"Successfull\"";
            }
        }
        return "\"UnSuccessfull\"";
    }
    public String decrement(int value, Long productId ,Principal principal )
    {
        ArrayList<cart> cart = getCartFrontUser(principal);
        Optional<items> items=simpleRepository.findById(productId);
        for(int i=0 ; i<cart.size() ; i++)
        {
            cart cartObj = cart.get(i);
            if(cartObj.getItm() == items.get())
            { int x =cartObj.getQuantity() -value;
            if(x == 1)
            {
            cartObj.setQuantity(1);
                cartRepository.save(cartObj);
                return "\"Successfull\"";
            }
        }
        return "\"unsuccessfull\"";
    }
    public List<orders> checkOut(Principal principal)
    {
       Optional<Users> users = userRepository.findByEmail(principal.getName());
        List <cart> cartList = cartRepository.findAllByUsers(users);
        for(cart cart : cartList)
        {
            orders orders = new orders();
            orders.setUserId(cart.getUsr().getId());
            orders.setQuantity(cart.getQuantity());
            orders.setPrice(cart.getItm().getPrice());
            orders.setItemName(cart.getItm().getName());
            orders.setDate(new Date());
            cartRepository.delete(cart);
            orderRepository.saveAndFlush(orders);


        }
        return orderRepository.findAllByUserId(users.get().getId());    }
}
