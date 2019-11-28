package com.example.demo.Controller;


import com.example.demo.Models.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Resultat;
import com.example.demo.Models.Vote;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.repositories.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping("")
public class UserController {
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    VoteRepo voteRepo ;


    @GetMapping("/allusers")
    public List<User> allusers(){
        return this.userRepo.findAll();
    }


    @PostMapping("/voter")
      public void  vote(@RequestBody int  idCandidate  ,@RequestBody String idVote , @RequestBody String idUser)

    {
        Vote vote = voteRepo.findByIdVote(idVote);
       vote.setTotalParticipent(vote.getTotalParticipent()+1);
       List<Candidate> candidateList =  vote.getListCandidatesParticipents() ;
       Candidate candidate = candidateList.get(idCandidate) ;
       int i =candidateList.indexOf(candidate);
      Resultat resultat = candidateList.get(i).getResultat();
      resultat.setResultatFinal(resultat.getResultatFinal()+1);









}}
