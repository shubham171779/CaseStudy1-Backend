package com.caseStudy.ecart.Controller;

import com.caseStudy.ecart.Repository.SimpleRepository;
import com.caseStudy.ecart.modal.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
    @RequestMapping("/api")
    public class ItemController {

        @Autowired
        SimpleRepository ItemRepository;
        @GetMapping("/items")
        public List<items> getAllItems()
        {
            return ItemRepository.findAll();
        }


}

