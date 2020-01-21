package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="resultats")
public class Resultat implements Comparable< Resultat>{
    @Id

    private  String id ;
    private int  resultatFinal  ;
    private int resultatParGenderFemme;
    private int resultatParGenderHomme;
    private int resultatParAgeJeune ;
    private int resultatparAgeMoyen ;
    private int resultatparAgeVieux;
    @DBRef
    private List   <Region>  resultatParRegison ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id ;
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
        return resultatParGenderHomme;
    }

    public void setResultatParGnederHomme(int resultatParGnederHomme) {
        this.resultatParGenderHomme = resultatParGnederHomme;
    }

    public int getResultatParAgeJeune() {
        return resultatParAgeJeune;
    }

    public void setResultatParAgeJeune(int resultatParAgeJeune) {
        this.resultatParAgeJeune = resultatParAgeJeune;
    }

    public int getResultatparAgeMoyen() {
        return resultatparAgeMoyen;
    }

    public void setResultatparAgeMoyen(int resultatparAgeMoyen) {
        this.resultatparAgeMoyen = resultatparAgeMoyen;
    }

    public int getResultatparAgeVieux() {
        return resultatparAgeVieux;
    }

    public Resultat() {
    }

    public void setResultatparAgeVieux(int resultatparAgeVieux) {
        this.resultatparAgeVieux = resultatparAgeVieux;
    }

    public List<Region> getResultatParRegison() {
        return resultatParRegison;
    }

    public void setResultatParRegison(List<Region> resultatParRegison) {
        this.resultatParRegison = resultatParRegison;
    }

    public Resultat(int resultatFinal, int resultatParGenderFemme, int resultatParGenderHomme, int resultatParAgeJeune, int resultatparAgeMoyen, int resultatparAgeVieux) {
        this.resultatFinal = resultatFinal;
        this.resultatParGenderFemme = resultatParGenderFemme;
        this.resultatParGenderHomme = resultatParGenderHomme;
        this.resultatParAgeJeune = resultatParAgeJeune;
        this.resultatparAgeMoyen = resultatparAgeMoyen;
        this.resultatparAgeVieux = resultatparAgeVieux;
    }

    @Override
    public int compareTo(Resultat o) {

        return (this.resultatFinal - o.getResultatFinal());
    }


}




