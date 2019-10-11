package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.Users;
import org.apache.catalina.startup.ListenerCreateRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryClass {
    @Autowired
    UserRepository userRespository;
    public void add(Users users) {
        System.out.println("Adding  a value");
        userRespository.save(users);
    }
    public Optional<Users> getByEmail(String email)
    {
        System.out.println("Getting by email");
        return userRespository.findByEmail(email);
    }
    public Optional<Users> getById (Long id) { return userRespository.findById(id);}
}
