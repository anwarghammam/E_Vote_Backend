package com.example.demo.repositories;

import com.example.demo.Models.User;
import com.example.demo.Models.video;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VideoRepo  extends MongoRepository<video,String> {

    //findById(String id);
    @Override
    List<video> findAll();

}
