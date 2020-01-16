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
    @Indexed
    private String id ;



   private  Date date ;
    @DBRef
    private List<Candidate> candidates ;

   private Integer participants ;
   private  String Subject ;
   private int likes ;
   private int loves ;
   private int hates ;
   private int wows ;
   private int angry ;
   private String url_image ;

   private String heure_deb ;
   private String  heure_fin  ;
   private Candidate candidat1;
   private Candidate candidat2;


    public Debate(Date date, List<Candidate> candidates, int participants, String subject, int likes, int loves, int hates, int wows, int angry) {
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

    public Debate(){

    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
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

    public int getParticipants() {
        return this.participants;
    }

    public void setParticipants(int participants) {
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

    public String getHeure_deb() {
        return heure_deb;
    }

    public void setHeure_deb(String heure_deb) {
        this.heure_deb = heure_deb;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public Candidate getCandidat1() {
        return candidat1;
    }

    public void setCandidat1(Candidate candidat1) {
        this.candidat1 = candidat1;
    }

    public Candidate getCandidat2() {
        return candidat2;
    }

    public void setCandidat2(Candidate candidat2) {
        this.candidat2 = candidat2;
    }
}
