package com.example.examen.repository;

import com.example.examen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByFNameAndLName(String fName,String lName);
}
