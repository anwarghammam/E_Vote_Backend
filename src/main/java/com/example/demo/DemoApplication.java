package com.example.demo;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.User;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.repositories.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
   @Autowired
  static UserRepo userRepo ;
   @Autowired

   static CandidateRepo candidateRepo ;
        @Autowired
   static VoteRepo voteRepo ;
    public  static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);




    }



}
