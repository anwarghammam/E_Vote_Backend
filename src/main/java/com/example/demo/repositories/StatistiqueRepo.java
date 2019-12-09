package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Statistique;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatistiqueRepo extends  MongoRepository<Statistique,String> {

    Statistique findByCandidate(Candidate candidate);
}
