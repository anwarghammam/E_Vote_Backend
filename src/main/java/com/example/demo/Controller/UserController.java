package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserRepo userRepo ;

    @GetMapping("/allusers")
    public List<User> allusers(){
        return this.userRepo.findAll();
    }










}
