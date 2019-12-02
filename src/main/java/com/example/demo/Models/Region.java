package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("regions")
public class Region {
    @Id

    private  String idRegion ;
    private  String nomRegion ;
    private int numberVote ;

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public int getNumberVote() {
        return numberVote;
    }

    public void setNumberVote(int numberVote) {
        this.numberVote = numberVote;
    }
}
