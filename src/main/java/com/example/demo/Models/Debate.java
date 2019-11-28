package com.example.demo.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;


@Document(collection="debates")
public class Debate {
    @Id
    private String id ;
   private  Date date ;
    @DBRef
    private List<Candidate> candidates ;
    @DBRef
    private List<User> participants ;
   private  String Subject ;

    public Debate(Date date, List<Candidate> candidates, List<User> participants, String subject) {
        this.date = date;
        this.candidates = candidates;
        this.participants = participants;
        this.Subject = subject;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Candidate> getCandidates() {
        return this.candidates;
    }

    public void setCondidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public List<User> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getSubject() {
        return this.Subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public void setSubject(String subject) {
        this.Subject = subject;
    }
}
