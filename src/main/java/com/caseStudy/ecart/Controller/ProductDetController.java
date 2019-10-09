package com.caseStudy.ecart.Controller;

import com.caseStudy.ecart.Repository.ProductDetails;
import com.caseStudy.ecart.modal.productDet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Pro")
public class ProductDetController {
    @Autowired
    ProductDetails proRepos;
@GetMapping("/product")
    public List<productDet> getpro()
{
    return proRepos.findAll();
}

@PostMapping("/prod")
    public productDet putData(@Valid @RequestBody productDet p)
{
    return proRepos.save(p);
}
}
