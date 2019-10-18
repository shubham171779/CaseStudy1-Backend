package com.caseStudy.ecart.Repository;

import com.caseStudy.ecart.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {

    public Optional<Users> findByEmail(String email);

}
