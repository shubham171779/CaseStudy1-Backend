package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.Users;
import com.caseStudy.ecart.modal.cart;
import com.caseStudy.ecart.modal.items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository<cart, Long> {
    public ArrayList<cart> findAllByUsers(Optional<Users> users);


    void deleteByUsersAndItems(Optional <Users> users, Optional <items> items);
}
