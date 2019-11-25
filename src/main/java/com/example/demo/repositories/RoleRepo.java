package com.example.demo.repositories;

import com.example.demo.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<Role, String> {

    Role findByRole(String role);
}