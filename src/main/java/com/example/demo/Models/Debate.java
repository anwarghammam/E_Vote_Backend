package com.example.demo.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document(collection="debates")
public class Debate {
    @Id
    private String id ;
    @Indexed(name = "date")
   private  Date date ;
    @DBRef
    private List<Condidate> condidates ;
    @DBRef
    private List<User> participants ;
   private  String Subject ;

    public Debate(Date date, List<Condidate> condidates, List<User> participants, String subject) {
        this.date = date;
        this.condidates = condidates;
        this.participants = participants;
        this.Subject = subject;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Condidate> getCondidates() {
        return this.condidates;
    }

    public void setCondidates(List<Condidate> condidates) {
        this.condidates = condidates;
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

    public void setSubject(String subject) {
        this.Subject = subject;
    }
}
