package com.caseStudy.ecart.Controller;

import com.caseStudy.ecart.Repository.UserRepository;
import com.caseStudy.ecart.modal.Users;
import com.caseStudy.ecart.modal.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/CreateRow")
    public String createitem(@Valid @RequestBody Users itm)
    {
        itm.setActive(1);
         usr.save(itm);
         return "\"Success\"";
    }
}
