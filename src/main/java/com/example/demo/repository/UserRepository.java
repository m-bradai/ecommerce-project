package com.example.demo.repository;

import com.example.demo.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

   User findByUserName(String userName);

}
