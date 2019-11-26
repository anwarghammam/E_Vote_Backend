package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CondidateRepo extends MongoRepository<Candidate, String> {

    Candidate findByName(String name) ;

    @Override
    List<Candidate> findAll();


    Candidate findByNumVote (int numVote) ;
}
