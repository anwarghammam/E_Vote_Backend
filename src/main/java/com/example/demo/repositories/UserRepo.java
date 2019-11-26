package com.example.demo.repositories;

import com.example.demo.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User, String> {
    User findUserByCin(String cin) ;
    List<User> findAll () ;
}
