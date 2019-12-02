package com.example.demo.Controller;

import com.example.demo.Models.Candidate;
import com.example.demo.repositories.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/candidate")
public class CondidateContrroller {

    @Autowired
    CandidateRepo   condidateRepo ;



    @GetMapping("/allcondidates")
    List<Candidate> showall(){
        return this.condidateRepo.findAll();

    }

    @GetMapping("/search condidate/{num_vote}")

    public String findcondidate(@PathVariable int num_vote){
        Candidate condidate =this.condidateRepo.findByNumVote(num_vote) ;
        if (condidate==null){
            return ("there is no condidate with this numvote");

        }
        else
            return(
                    condidate.getName()+" "+condidate.getOccupation()+" "+condidate.getStatus()
                    );


    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Candidate condidate =this.condidateRepo.findByNumVote(id) ;
        this.condidateRepo.delete(condidate);
        return ("user deleted ") ;
    }


    @GetMapping("/createprogram/{id}/{programs}")
    public String Add_Programs(@PathVariable String[] programs ,@PathVariable int id ) {
        Candidate condidate =this.condidateRepo.findByNumVote(id) ;
        condidate.setPrograms(programs);
        this.condidateRepo.save(condidate);
        return ("programs enregistred ") ;


    }







}
