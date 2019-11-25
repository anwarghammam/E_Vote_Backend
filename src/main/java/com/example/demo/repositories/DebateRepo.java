package com.example.demo.repositories;

import com.example.demo.Models.Debate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface DebateRepo extends MongoRepository<Debate,String > {




}
