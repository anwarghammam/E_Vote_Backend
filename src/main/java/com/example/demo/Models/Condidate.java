package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "Condidates")
public class Condidate {
    @Id
    @Indexed(name = "Id_Vote")
    private String  id_vote ;
    private String name ;
    private String password ;
    private String lastname ;
    private String[] programs ;
    private String job ;
    @DBRef
    private Set<Role> roles;

    public Condidate(String name, String lastname, String[] programs, String job) {

        this.name = name;
        this.lastname = lastname;
        this.programs = programs;
        this.job = job;
    }

    public String getId_vote() {
        return this.id_vote;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String[] getPrograms() {
        return this.programs;
    }

    public void setPrograms(String[] programs) {
        this.programs = programs;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
