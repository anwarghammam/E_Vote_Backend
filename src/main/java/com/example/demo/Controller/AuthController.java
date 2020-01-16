package com.example.demo.Controller;

import com.example.demo.Models.Role;
import com.example.demo.Models.User;
import com.example.demo.configs.JwtTokenProvider;
import com.example.demo.repositories.RoleRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    RoleRepo rolerepo ;

    @Autowired
    private CustomUserDetailsService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            String username = user.getCin();
            System.out.println(username);

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, user.getPassword()));


            String token = jwtTokenProvider.createToken(username, this.users.findByCin(username).getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            //model.put("role",this.users.findByCin(username).getRoles());
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
            return new ResponseEntity("User with cin: " + user.getCin() + " already exists", HttpStatus.BAD_REQUEST);

        }
             Role e = new Role("5ddd8215fdb681718c00f54f","USER");


        Set<Role> roles = new HashSet<Role>();
        roles.add(e) ;
        user.setRoles(roles);
        userService.saveUser(user);
        System.out.println(user.toString());
        System.out.println(this.users.findByCin(user.getCin()).toString());

        return new ResponseEntity("done", HttpStatus.OK);
    }
}
