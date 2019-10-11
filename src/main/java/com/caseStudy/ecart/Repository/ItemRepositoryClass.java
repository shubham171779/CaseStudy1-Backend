package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.items;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class ItemRepositoryClass {
    @Autowired
    SimpleRepository sim;
    public boolean additems(items item)
    {
        try{
            System.out.println("Adding a product");
            sim.save(item);
            System.out.println("Product added");
            return true;
        }
        catch (Exception e) {

            return false;
        }
    }
    public ArrayList<items> getAllProducts() {
        return (ArrayList<items>) sim.findAll();
    }
    public Optional<items> getField(Long id) {
        return sim.findById(id);
    }
    public Optional<items> getById(Long id)
    {
        return sim.findById(id);
    }
}

