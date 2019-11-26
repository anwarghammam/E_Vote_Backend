package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document(collection = "candidates")
public class Condidate  extends  User {

    @Field("idVote")
    private int idVote;
    private String[] programs;
  // final result of specific candidates ;
    private int rank ;
    public String[] getPrograms() {
        return this.programs;
    }

    public void setPrograms(String[] programs) {
        this.programs = programs;
    }

    public int getIdVote() {
        return idVote;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setIdVote(int idVote) {
        this.idVote = idVote;
    }
}


