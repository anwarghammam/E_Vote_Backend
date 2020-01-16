package com.example.demo.Controller;


import com.example.demo.Models.Candidate;
import com.example.demo.Models.Debate;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.DebateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.jsonwebtoken.lang.Collections.size;
import static jdk.nashorn.internal.objects.ArrayBufferView.length;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/candidate")

public class DebateController {

    @Autowired
    DebateRepo debaterepo ;


    @GetMapping("/allfuturdebates")
    List<Debate> showall(){
        Date date = new Date();
        System.out.println(date.getDate());

        List<Debate> futurdebates =new ArrayList<Debate>();

        List<Debate> debates = this.debaterepo.findAll();
          for(int i=0;i<debates.size();i++){

              if(debates.get(i).getDate().compareTo(date)>0){
                  futurdebates.add(debates.get(i));

              }
          }


       return futurdebates ;   }
    @GetMapping("/allcloseddebates")
    List<Debate> closeddebates(){
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println("******");
        List<Debate> passeddebates=new ArrayList<Debate>();
        List<Debate> debates = this.debaterepo.findAll();
        System.out.println("******");
        for(int i=0;i<size(debates);i++){
            if(debates.get(i).getDate().compareTo(date)<0){
                System.out.println("*");
                passeddebates.add(debates.get(i));
                System.out.println("**");

            }
        }
        System.out.println("******");
        return passeddebates ;

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
    public ResponseEntity Add_Programs(@RequestBody Debate debate ) {
       Debate debate1= this.debaterepo.findDebateByDate(debate.getDate());
       if (debate1 !=null ){
           return  new ResponseEntity("date already taken", HttpStatus.BAD_REQUEST);
       }
       else {
           this.debaterepo.save(debate);
           return new ResponseEntity("ok",HttpStatus.ACCEPTED);
       }
    }

    @GetMapping("/like/{id}")
    public int add_like(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setLikes(debate.getLikes()+1);
        this.debaterepo.save(debate);
        return(debate.getLikes()) ;

    }
    @GetMapping("/angry/{id}")
    public int add_angry(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setAngry(debate.getAngry()+1);
        this.debaterepo.save(debate);
        return(debate.getAngry()) ;
    }
    @GetMapping("/love/{id}")
    public void add_love(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setLoves(debate.getLoves()+1);
        this.debaterepo.save(debate);


    }
    @GetMapping("/participate/{id}")
    public int add_participant(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        System.out.println(debate.getParticipants());
        debate.setParticipants(debate.getParticipants()+1);
        System.out.println((debate.getParticipants()));
        this.debaterepo.save(debate);
    return(debate.getParticipants());}

    @GetMapping("/wow/{id}")
    public void add_wow(@PathVariable String id){
        Debate debate = this.debaterepo.findDebateById(id);
        debate.setWows(debate.getWows()+1);
        this.debaterepo.save(debate);


    }








}
