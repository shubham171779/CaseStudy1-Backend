package com.caseStudy.ecart.Service;

import com.caseStudy.ecart.Repository.CartRepository;
import com.caseStudy.ecart.Repository.ItemRepositoryClass;
import com.caseStudy.ecart.Repository.SimpleRepository;
import com.caseStudy.ecart.Repository.UserRepositoryClass;
import com.caseStudy.ecart.modal.Users;
import com.caseStudy.ecart.modal.cart;
import com.caseStudy.ecart.modal.items;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepositoryClass userRepositoryClass;
    @Autowired
    SimpleRepository simpleRepository;

    ItemRepositoryClass itemRepositoryClass;
    private ArrayList<cart> getCartFrontUser(Principal principal) {
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
        ArrayList<cart> car = cartRepository.findAllByUsers(users);
        return car;
    }
    public ArrayList<cart> getEmail(Principal principal) {
        String email = principal.getName();
        Optional<Users> users= userRepositoryClass.getByEmail(email);
        return cartRepository.findAllByUsers(users);
    }
    public String additemstoCart(Principal principal, Long id) {
        Optional<items> item = simpleRepository.findById(id);
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
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
        Optional<Users> users = userRepositoryClass.getByEmail(principal.getName());
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
            {
                cartObj.setQuantity(cartObj.getQuantity() - value);
                cartRepository.save(cartObj);
                return "\"Successfull\"";
            }
        }
        return "\"unsuccessfull\"";
    }

}
