package com.caseStudy.ecart.Controller;

import com.caseStudy.ecart.Exception.ResourceNotFoundException;
import com.caseStudy.ecart.Repository.SimpleRepository;
import com.caseStudy.ecart.modal.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
    @RequestMapping("/api")
    public class ItemController {

        @Autowired
        SimpleRepository ItemRepository;
        @GetMapping("/getallitems")
        public List<items> getAllItems()
        {
            return ItemRepository.findAll();
        }
        @PostMapping("/CreateRow")
        public items createitem(@Valid @RequestBody items itm)
        {
            return ItemRepository.save(itm);
        }
        @GetMapping("/GetAitem/{id}")
    public items getItems(@PathVariable (value = "id") Long itemId)
        {
            return ItemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("Note","Id",itemId));
        }
        @PatchMapping("/Patch/{id}")
    public items putItems(@PathVariable (value="id") Long itemId,@Valid @RequestBody items itm1)
        {
            items itm2=ItemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("Note","Id",itemId));
            itm2.setPrice(itm1.getPrice());
            itm2.setCategory(itm1.getCategory());
            items itm3=ItemRepository.save(itm2);
            return itm3;
        }
        @GetMapping("category/{cat}")
    public List<items> getdetailsCat(@PathVariable(value="cat")String category)
        {
            return ItemRepository.findByCategory(category);
        }
        @GetMapping("id/{id}")
        public items getElementById(@PathVariable(value="id")Long prodId)
        {
            return ItemRepository.findById(prodId).orElseThrow(()->new ResourceNotFoundException("details","id",prodId));
        }

}

