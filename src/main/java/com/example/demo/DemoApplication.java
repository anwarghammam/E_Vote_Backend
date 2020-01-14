package com.example.demo;
import com.example.demo.Models.Candidate;
import com.example.demo.Models.Debate;
import com.example.demo.Models.Role;
import com.example.demo.Models.Vote;
import com.example.demo.repositories.CandidateRepo;
import com.example.demo.repositories.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    VoteRepo voteRepo ;

    public  static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


    }}


