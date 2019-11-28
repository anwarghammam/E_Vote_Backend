package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Document(collection = "candidates")
public class Candidate extends  User {

    @Field("idVote")
   @Indexed
    private int numVote;
    private String[] programs;
  // final result of specific candidates ;
    private int rank ;
    @DBRef
    private Resultat resultat ;

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }
    public String[] getPrograms() {
        return this.programs;
    }

    public void setPrograms(String[] programs) {
        this.programs = programs;
    }

    public int getNumVote() {
        return numVote;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setNumVote(int idVote) {
        this.numVote = idVote;
    }
}


