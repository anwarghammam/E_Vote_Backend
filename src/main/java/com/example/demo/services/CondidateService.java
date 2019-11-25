package com.example.demo.services;

import com.example.demo.Models.Condidate;
import com.example.demo.Models.Role;
import com.example.demo.repositories.CondidateRepo;
import com.example.demo.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

/*import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
@Controller
public class CondidateService {

    @Autowired
    private CondidateRepo condidateRepo ;
    @Autowired
    private RoleRepo role ;



    public List<Condidate> getAllCondidates(){
        return this.condidateRepo.findAll() ;
    }
    public Condidate findCondidatebyid (String id) {
        return condidateRepo.findById_vote(id);
    }
   /* public void saveCondidate(Condidate cdt) {
        cdt.setPassword(bCryptPasswordEncoder.encode(cdt.getPassword()));

        Role condidateRole = role.findByRole("CONDIDATE");
        cdt.setRoles(new HashSet<>(Arrays.asList(condidateRole)));
        condidateRepo.save(cdt);


    }*/



