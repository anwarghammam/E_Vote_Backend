package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CandidateRepo extends MongoRepository<Candidate, String> {

    Candidate findByName(String name) ;
    Candidate findByNumVote (int numVote) ;
    Candidate findByCin(String cin);
}
