package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Statistique;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StatistiqueRepo extends  MongoRepository<Statistique,String> {

    Statistique findByCandidate(Candidate candidate);
    Statistique findByIdStatistique(String id) ;
    Statistique findByIdVote(String idVote);
    List<Statistique>  findAllByIdVote(String idVote);
}
