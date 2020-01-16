package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.User;
import com.example.demo.Models.Vote;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface VoteRepo extends MongoRepository<Vote, String> {

Vote findByIdVote (String idVote)  ;

List<Candidate> findAllByListCandidatesParticipents() ;
List<Vote>findAllByActivated(Boolean activated);
}
