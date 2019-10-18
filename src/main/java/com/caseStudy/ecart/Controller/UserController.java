package com.caseStudy.ecart.Controller;

import com.caseStudy.ecart.Exception.ResourceNotFoundException;
import com.caseStudy.ecart.Repository.UserRepository;
import com.caseStudy.ecart.Service.CartService;
import com.caseStudy.ecart.modal.Users;
import com.caseStudy.ecart.modal.cart;
import com.caseStudy.ecart.modal.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartService cartService;
    @GetMapping("/allusers")
    public List<Users> getAllItems()
    {
        return userRepository.findAll();
    }
    @PostMapping("/CreateRow")
    public String createitem(@Valid @RequestBody Users itm)
    {
        itm.setActive(1);
         userRepository.save(itm);
         return "\"Success\"";
    }
    @GetMapping("/users")
    public Optional<Users> getCart(Principal principal) {return userRepository.findByEmail(principal.getName());}
    @PutMapping("/updateuser/{id}")
    public Users updateUser(@PathVariable(value = "id") Long id, @RequestBody Users newusr)
    {
        Users user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Users","user-id",id));
        user.setEmail(newusr.getEmail());
        user.setPassword(newusr.getPassword());

        Users updateditem = userRepository.save(user);
        return updateditem;

    }
}
