package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.example.demo.configs.JwtTokenProvider;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepo users;

    @Autowired
    private CustomUserDetailsService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            String username = user.getCin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.findUserByCin(username).getRoles());
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        User userExists = userService.findUserByEmail(user.getCin());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getCin() + " already exists");
        }
        System.out.println(user.getPassword()+""+user.getCin()+""+user.getName());
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
}
