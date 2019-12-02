package com.example.demo.Controller;


import com.example.demo.Models.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Resultat;
import com.example.demo.Models.User;
import com.example.demo.Models.Vote;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.ResultatRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.repositories.VoteRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")

public class UserController {
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    CandidateRepo candidateRepo;
    @Autowired
    VoteRepo voteRepo ;

  @Autowired
  ResultatRepo resultatRepo ;



    @GetMapping("/allusers")
    public List<User> allusers(){
        return this.userRepo.findAll();
    }

    @PostMapping("/vote")
      public void  vote(@RequestParam String cin  , @RequestParam String idVote , @RequestParam int indexCandidate) {

        User user = userRepo.findByCin(cin);
        // verify if the user already voted
        if (user.isVoted()) {
            System.out.println("already voted");
        }
        else {
            Vote vote = voteRepo.findByIdVote(idVote);
            System.out.println("+++++++++++++++" + vote.getTotalParticipent());
            vote.setTotalParticipent(vote.getTotalParticipent() + 1);
            Candidate candidate1 = candidateRepo.findByNumVote(indexCandidate);
            System.out.println("++++++++++++++++++++++++++++++++++***************" + candidate1.getUser_id());
            List<Candidate> candidateList = vote.getListCandidatesParticipents();
            int i = 0;
            while (i < candidateList.size()) {
                if ((candidateList.get(i).getNumVote()) == candidate1.getNumVote()) {
                    break;
                }
                i++;
            }

            System.out.println("++++++++++++++++++++++++++++++++++***************" + i);
            Resultat resultat = candidate1.getResultat();
            resultat.setResultatFinal(resultat.getResultatFinal() + 1);
            if( ((user.getAge()<30) && (user.getAge() >18)))
            {
                resultat.setResultatParAgeJeune(resultat.getResultatParAgeJeune()+1);
            }
            if( ((user.getAge()>30) && (user.getAge() <60))) {
                resultat.setResultatparAgeMoyen(resultat.getResultatparAgeMoyen()+1);
            }
              else {
                  resultat.setResultatparAgeVieux(resultat.getResultatparAgeVieux()+1);
            }
              if(user.getGender() =="femme")
              {
                  resultat.setResultatParGenderFemme(resultat.getResultatParGenderFemme()+1);
              }
                else {
                    resultat.setResultatParGnederHomme(resultat.getResultatParGnederHomme()+1);
              }
            resultatRepo.save(resultat);
            candidate1.setResultat(resultat);
            candidateRepo.save(candidate1);
            candidateList.set(i, candidate1);
            vote.setListCandidatesParticipents(candidateList);
            voteRepo.save(vote);
            user.setVoted(true);
            userRepo.save(user) ;

            // test gender - region - status of user and update resultat
            //  Candidate candidate  =  candidateRepo.findByNumVote(numCandidate) ;*/


        }
    }
}



