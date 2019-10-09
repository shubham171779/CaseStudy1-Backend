package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
