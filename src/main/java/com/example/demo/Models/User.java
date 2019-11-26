package com.example.demo.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.Set;

@Document(collection="user")
public class User {
    @Id

    private String User_id ;

    private String name ;
  private  String cin ;
   private  String password ;
    @DBRef
    private Set<Role> roles;


    public User(String name, String cin, String password, Set<Role> roles) {
        this.name = name;
        this.cin = cin;
        this.password = password;
        this.roles = roles;
    }
    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
