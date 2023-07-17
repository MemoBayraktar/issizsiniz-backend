package com.group3.issizsiniz.repository;


import com.group3.issizsiniz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Boolean existsByEmail(String email);

}
