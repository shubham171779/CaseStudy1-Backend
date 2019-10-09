package com.caseStudy.ecart.Controller;

import com.caseStudy.ecart.Repository.UserRepository;
import com.caseStudy.ecart.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository usr;
    @GetMapping("/allusers")
    public List<Users> getAllItems()
    {
        return usr.findAll();
    }

}
