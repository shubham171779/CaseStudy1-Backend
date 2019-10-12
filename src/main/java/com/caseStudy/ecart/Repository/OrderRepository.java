package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<orders, Long> {

    List<orders> findAllByUserId(Long t);
}
