package com.example.demo.Controller;


import com.example.demo.Models.Candidate;
import com.example.demo.Models.Debate;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.DebateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/candidate")

public class DebateController {
    @Autowired
    DebateRepo debaterepo ;



    @GetMapping("/alldebates")
    List<Debate> showall(){
        return this.debaterepo.findAll();

    }

    @GetMapping("/search debate/{date}")

    public String findcdebate(@PathVariable Date date){
       Debate debate = this.debaterepo.findDebateByDate(date) ;
        if (debate==null){
            return ("there is no debate in this date");

        }
        else
            return(
                    debate.getSubject()
            );


    }


    @GetMapping("/delete/{date}")
    public String delete(@PathVariable Date date) {
        Debate debate =this.debaterepo.findDebateByDate(date) ;
        this.debaterepo.delete(debate);
        return ("debate deleted") ;
    }


    @PostMapping("/create_debate")
    public String Add_Programs(@RequestBody Debate debate ) {
       Debate debate1= this.debaterepo.findDebateByDate(debate.getDate());

        if(debate1!=null)
        {
            return("this date is taken , you should change the date ");
        }
        this.debaterepo.save(debate);
        return ("debate created ");


    }

    @GetMapping("/like/{id}")
    public void add_like(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setLikes(debate.getLikes()+1);



    }
    @GetMapping("/love/{id}")
    public void add_love(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setLoves(debate.getLoves()+1);



    }
    @GetMapping("/wow/{id}")
    public void add_wow(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setWows(debate.getWows()+1);



    }
    @GetMapping("/angry/{id}")
    public void add_angry(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setAngry(debate.getAngry()+1);



    }






}
