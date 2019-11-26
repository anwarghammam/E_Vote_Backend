package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection="resultats")
public class Resultat {
    @Id

    private  String id ;
    @Indexed
    private int  resultatFinal ;
    private int resultatParGenderFemme;
    private int resultatParGnederHomme ;
    private String resultatParAgeJeune ;
    private String resultatparAgeMoyen ;
    private String resultatparAgeVieux;
    @DBRef
    private List   <Region>  resultatParRegison ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResultatFinal() {
        return resultatFinal;
    }

    public void setResultatFinal(int resultatFinal) {
        this.resultatFinal = resultatFinal;
    }

    public int getResultatParGenderFemme() {
        return resultatParGenderFemme;
    }

    public void setResultatParGenderFemme(int resultatParGenderFemme) {
        this.resultatParGenderFemme = resultatParGenderFemme;
    }

    public int getResultatParGnederHomme() {
        return resultatParGnederHomme;
    }

    public void setResultatParGnederHomme(int resultatParGnederHomme) {
        this.resultatParGnederHomme = resultatParGnederHomme;
    }

    public String getResultatParAgeJeune() {
        return resultatParAgeJeune;
    }

    public void setResultatParAgeJeune(String resultatParAgeJeune) {
        this.resultatParAgeJeune = resultatParAgeJeune;
    }

    public String getResultatparAgeMoyen() {
        return resultatparAgeMoyen;
    }

    public void setResultatparAgeMoyen(String resultatparAgeMoyen) {
        this.resultatparAgeMoyen = resultatparAgeMoyen;
    }

    public String getResultatparAgeVieux() {
        return resultatparAgeVieux;
    }

    public void setResultatparAgeVieux(String resultatparAgeVieux) {
        this.resultatparAgeVieux = resultatparAgeVieux;
    }

    public List<Region> getResultatParRegison() {
        return resultatParRegison;
    }

    public void setResultatParRegison(List<Region> resultatParRegison) {
        this.resultatParRegison = resultatParRegison;
    }
}




