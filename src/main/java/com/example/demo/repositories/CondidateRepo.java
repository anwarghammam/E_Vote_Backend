package com.example.demo.repositories;

import com.example.demo.Models.Condidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CondidateRepo extends MongoRepository<Condidate, String> {

    Condidate findByName(String name) ;

    @Override
    List<Condidate> findAll();
}
