package com.example.demo.Controller;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Resultat;
import com.example.demo.Models.Role;
import com.example.demo.repositories.CandidateRepo;

import com.example.demo.repositories.UserRepo;

import com.example.demo.repositories.ResultatRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/candidate")
public class CondidateContrroller {

    @Autowired
    CandidateRepo   condidateRepo ;
    @Autowired

    UserRepo UserRepo ;
    @Autowired
    ResultatRepo resultatRepo ;



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

    @PostMapping("/add")
    public void addCandidat(@RequestBody Candidate candidate){

        Role e = new Role("5ddd8215fdb681718c00f54f","USER");
        Role e1 = new Role("5ddd8215fdb681718c00f550","CONDIDATE");


        Set<Role> roles = new HashSet<Role>();
        roles.add(e) ;
        roles.add(e1) ;
        candidate.setRoles(roles);

        Resultat  resultat = new Resultat();
       // Resultat resultat = new Resultat(0,0,0,0,0,0);
        resultat.setResultatParGnederHomme(0);
        resultat.setResultatParGenderFemme(0);
        resultat.setResultatFinal(0);
        resultat.setResultatParAgeJeune(0);
        resultat.setResultatparAgeMoyen(0);
        resultat.setResultatparAgeVieux(0);
        resultatRepo.save(resultat);
        candidate.setResultat(resultat);

        candidate.setPassword(candidate.getCin());

        this.condidateRepo.save(candidate);
        this.UserRepo.save(candidate);
        System.out.println("anwar"+candidate);
    }

    @PostMapping("/addprogram/{id}")
    public  void addProgrammeCandidate(@PathVariable String id, @RequestBody String[] programme){
        Candidate candidate = this.condidateRepo.findByCin(id);

        candidate.setPrograms(programme);
        this.condidateRepo.save(candidate);
    }

    @PostMapping("/addvideostocandidat/{id}")
    public  void addVideoCandidate(@PathVariable String id, @RequestBody String[] videos){

        Candidate candidate = this.condidateRepo.findByCin(id);

        this.condidateRepo.save(candidate);
    }
    /*
    @GetMapping("/createCandidate")
    public void createCandidattest(){

        Role role= new Role("1", "candidat");
        Set<Role> roles=new HashSet<>() ;
        roles.add(role);
        Candidate candidate =new Candidate("imen","11445566","imen",roles );
        this.condidateRepo.save(candidate);
        Candidate candidate1 =new Candidate("anwar","11449566","anwar",roles );
        this.condidateRepo.save(candidate1);
        Candidate candidate2 =new Candidate("insaf","11223355","insaf",roles );
        this.condidateRepo.save(candidate2);

    } */
}
