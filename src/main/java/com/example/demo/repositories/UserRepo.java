package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.User;
import com.example.demo.Models.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User,String> {

    public User findByCin(String cin) ;
    @Override
    List<User> findAll();
    User findUserByCin(String cin) ;



}
