package com.example.demo.Controller;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Vote;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteRepo voteRepo ;

    @Autowired
    private CandidateRepo candidateRepo ;
    @PostMapping("/add")
    public ResponseEntity addVote(@RequestBody Vote votes) {


        votes.setActivated(null);
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < votes.getListCandidatesParticipents().size(); i++) {
            Candidate candidate = candidateRepo.findByCin(votes.getListCandidatesParticipents().get(i).getCin());
            candidates.add(candidate);
        }

        votes.setListCandidatesParticipents(candidates);
        this.voteRepo.save(votes);
        return new ResponseEntity("ok", HttpStatus.ACCEPTED);
    }

    @PostMapping("/activate")
    public void activateVote(@RequestBody String id){


        Vote vote=voteRepo.findByIdVote(id);
        if (vote !=null){
            System.out.println(vote.getIdVote()+""+vote.getDateEnd());

            vote.setActivated(true);
            voteRepo.save(vote);
        }
    }

    @GetMapping("/getall")
    public  List<Vote> createListeVote(){
        List<Vote> votes= this.voteRepo.findAll() ;
        return  votes ;
    }


    @GetMapping("/getupcommingvotes")
    public List<Vote> getUpComming(){
    List<Vote>votes=this.voteRepo.findAllByActivated(null);
    return  votes ;
    }

    @GetMapping("activevote")
    public List<Vote> activeVote(){
        List<Vote>votes =this.voteRepo.findAllByActivated(new Boolean(true));
        return votes ;
    }

    @PostMapping("activatedesactivate")
    public List<Vote> activate(@RequestBody List<Vote>votes){
        System.out.println("hhhh");
        for (int i=0;i<votes.size();i++){
           this.voteRepo.save(votes.get(i));
        }
        return votes ;
    }

    @GetMapping("vote")
    public Vote getOneVote(){
        return this.voteRepo.findAllByActivated(new Boolean(true)).get(0) ;
    }
}

