package com.example.demo.repositories;

import com.example.demo.Models.Region;
import com.example.demo.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepo extends MongoRepository<Region, String>{
}
