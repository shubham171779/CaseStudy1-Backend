package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.items;
import com.caseStudy.ecart.modal.productDet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetails extends JpaRepository<productDet,Long> {

}
