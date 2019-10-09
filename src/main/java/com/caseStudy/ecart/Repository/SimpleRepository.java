package com.caseStudy.ecart.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.caseStudy.ecart.modal.items;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimpleRepository extends JpaRepository<items, Long>
{
    @Override
    List<items> findAll();
    List<items> findByCategory(String category);
}

