package com.caseStudy.ecart.Service;

import com.caseStudy.ecart.Repository.SimpleRepository;
import com.caseStudy.ecart.modal.items;
//import com.sun.tools.javac.jvm.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {


    @Autowired

    SimpleRepository itemRepository;
    public ItemService()
    {

    }

    public items edititem(items newitm, Long id)
    {
        items olditem = itemRepository.findById(id).get();
        newitm.setProductId(olditem.getProductId());
        newitm.setActive(olditem.getActive());
        itemRepository.save(newitm);
        return newitm;
    }}
