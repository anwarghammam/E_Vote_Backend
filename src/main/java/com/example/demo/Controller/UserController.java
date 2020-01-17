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

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vote")

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

    @GetMapping("/user/{cin}")
    public User getuser(@PathVariable String cin){
        return this.userRepo.findByCin(cin);
    }


    @PostMapping("/voter")
      public void  vote(@RequestBody int  idCandidate  ,@RequestBody String idVote , @RequestBody String idUser) {

        Vote vote = voteRepo.findByIdVote(idVote);
        vote.setTotalParticipent(vote.getTotalParticipent() + 1);
        List<Candidate> candidateList = vote.getListCandidatesParticipents();
        Candidate candidate = candidateList.get(idCandidate);
        int i = candidateList.indexOf(candidate);
        Resultat resultat = candidateList.get(i).getResultat();
        resultat.setResultatFinal(resultat.getResultatFinal() + 1);
    }
    /*@PostMapping("/createVote")
    public void creatVote(@RequestBody Vote   vote)

    {
          voteRepo.save(vote);
    }*/

    @PostMapping("/createResultat")
    public void createsultat(@RequestBody Resultat   resultat)

    {
        resultatRepo.save(resultat);
        Candidate candidate = candidateRepo.findByCin("1111");

        candidate.setResultat(resultat);
        candidateRepo.save(candidate);
        Vote vote = voteRepo.findByIdVote("1");
        List<Candidate> l = vote.getListCandidatesParticipents();
        l.add(candidate);
        vote.setListCandidatesParticipents(l);
        voteRepo.save(vote);
    }



/*
@PostMapping("/candidate")
      public void createcandidate()
    {  Candidate candidate1 = candidateRepo.findByCin("0000");
       System.out.println("55555555555555555555555555555555555555555555555+++++++++++"+candidate1.getCin());
        Vote vote = voteRepo.findByIdVote("123456789");
    List<Candidate> l = vote.getListCandidatesParticipents();
         l.add(candidate1);
        System.out.println("55555555555555555555555555555555555555555555555+++++++++++"+l.size());
         vote.setListCandidatesParticipents(l);
         voteRepo.save(vote);
    }*/
    @GetMapping("/accueilUser")
      public   List <Candidate> getAllCandidates(@RequestParam String  idVote )
      {
          Vote vote = voteRepo.findByIdVote(idVote);

          List <Candidate>  candidates= vote.getListCandidatesParticipents();
          return candidates ;
      }
      @GetMapping("/verfiSatusVote")
      public boolean verfiSatusVote(@RequestParam String idVote)
      {
          Vote vote = voteRepo.findByIdVote(idVote);

          System.out.println("status vote *******************"+vote.isActivated());
            return vote.isActivated();

      }

    @GetMapping("/UserVoteVerif")
    public boolean UserVoteVerif(@RequestParam String cin)
    {
       User user = userRepo.findByCin(cin);

        System.out.println("user voted  vote *******************"+user.isVoted());
        return user.isVoted();

    }


    @RequestMapping(value = "/vote", method = RequestMethod.GET)
      public void  vote (@RequestParam  String cin  ,@RequestParam  String idVote , @RequestParam  int indexCandidate) {
        System.out.println("--------------------------------------vote  action------------");

        User user = userRepo.findByCin(cin);
      // verify if the user already voted
        if (user.isVoted()) {
            System.out.println("already voted");
        }
        else {
            Vote vote = voteRepo.findByIdVote(idVote);
            System.out.println("+++++++++++++++" + vote.getTotalParticipent());
            vote.setTotalParticipent(vote.getTotalParticipent() + 1);
            System.out.println("after vote" + vote.getTotalParticipent());
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
          if( ((user.getAge()<30) && (user.getAge() >=18)))
            {
                resultat.setResultatParAgeJeune(resultat.getResultatParAgeJeune()+1);
            }
            if( ((user.getAge()>=30) && (user.getAge() <60))) {
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




        }
    }

    @RequestMapping(value = "/follow/{numVote}/{cin}", method = RequestMethod.GET)
    public int follow(@PathVariable int numVote,@PathVariable String cin){
        Candidate c =  candidateRepo.findByNumVote(numVote);
        System.out.println(c);
        User user = userRepo.findByCin(cin);
        System.out.println(user);
        Set<User> users = c.getFollwers();
         users.add(user);
        System.out.println(user);
        c.setFollwers(users) ;
        c.setFollows(c.getFollows()+1);
        System.out.println(user);
        candidateRepo.save(c);
        System.out.println(user);
        return c.getFollows() ;
    }
    @RequestMapping(value = "/unfollow/{numVote}/{cin}", method = RequestMethod.GET)
    public int unfollow(@PathVariable int numVote,@PathVariable String cin){
        Candidate c =  candidateRepo.findByNumVote(numVote);
        System.out.println(c);
        User user = userRepo.findByCin(cin);
        System.out.println(user);
        Set<User> users = c.getFollwers();
        users.add(user);
        System.out.println(user);
        c.setFollwers(users) ;
        c.setFollows(c.getFollows()-1);
        System.out.println(user);
        candidateRepo.save(c);
        System.out.println(user);
        return c.getFollows() ;
    }

}



