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
   private int likes ;
   private int loves ;
   private int hates ;
   private int wows ;
   private int angry ;


    public Debate(Date date, List<Candidate> candidates, List<User> participants, String subject, int likes, int loves, int hates, int wows, int angry) {
        this.date = date;
        this.candidates = candidates;
        this.participants = participants;
        Subject = subject;
        this.likes = likes;
        this.loves = loves;
        this.hates = hates;
        this.wows = wows;
        this.angry = angry;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLoves() {
        return loves;
    }

    public void setLoves(int loves) {
        this.loves = loves;
    }

    public int getHates() {
        return hates;
    }

    public void setHates(int hates) {
        this.hates = hates;
    }

    public int getWows() {
        return wows;
    }

    public void setWows(int wows) {
        this.wows = wows;
    }

    public int getAngry() {
        return angry;
    }

    public void setAngry(int angry) {
        this.angry = angry;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public void setSubject(String subject) {
        this.Subject = subject;
    }
}
