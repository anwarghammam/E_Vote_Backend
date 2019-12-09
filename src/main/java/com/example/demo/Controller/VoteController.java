package com.example.demo.Controller;

import com.example.demo.Models.Vote;
import com.example.demo.repositories.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteRepo voteRepo ;
    @RequestMapping("/add")
    public void addVote(@RequestBody Vote vote){
      vote.setActivated(false);
      this.voteRepo.save(vote) ;
    }
   @RequestMapping("/activate")
    public void activateVote(@RequestBody String id){
        System.out.println(id);
        Vote vote=voteRepo.findByIdVote(id);
        if (vote !=null){
            System.out.println(vote.getIdVote()+""+vote.getDateEnd());

            vote.setActivated(true);
            voteRepo.save(vote);
        }
    }
}

