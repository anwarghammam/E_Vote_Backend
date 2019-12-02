package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.User;
import com.example.demo.Models.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface VoteRepo extends MongoRepository<Vote, Long> {

    Vote findByIdVote (Long idVote)  ;
   List<Candidate> findAllByListCandidatesParticipents() ;

}
