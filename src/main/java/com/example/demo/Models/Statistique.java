package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "statistiques")
public class Statistique {
@Id
@Indexed
    String idStatistique ;
    @DBRef
    Candidate candidate ;
    double pourcentageFemme ;
    double pourcentageHomme ;
    double pourcentageJeune ;
    double pourcentageVieux ;
    double getPourcentageAdulte ;
    int total ;
    double pourcentageTotal ;
    public Statistique() {
    }

    public Statistique(String idStatistique, Candidate candidate,double pourcentageTotal , double pourcentageFemme, double pourcentageHomme, double pourcentageJeune, double pourcentageVieux, double getPourcentageAdulte, int total) {
        this.idStatistique = idStatistique;
       this.candidate = candidate ;
        this.pourcentageFemme = pourcentageFemme;
        this.pourcentageHomme = pourcentageHomme;
        this.pourcentageJeune = pourcentageJeune;
        this.pourcentageVieux = pourcentageVieux;
        this.getPourcentageAdulte = getPourcentageAdulte;
        this.total = total;
    }

    public String getIdStatistique() {
        return idStatistique;
    }

    public void setIdStatistique(String idStatistique) {
        this.idStatistique = idStatistique;
    }

    public Candidate getCandidate() {
        return this.candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public double getPourcentageFemme() {
        return pourcentageFemme;
    }

    public void setPourcentageFemme(double pourcentageFemme) {
        this.pourcentageFemme = pourcentageFemme;
    }

    public double getPourcentageHomme() {
        return pourcentageHomme;
    }

    public void setPourcentageHomme(double pourcentageHomme) {
        this.pourcentageHomme = pourcentageHomme;
    }

    public double getPourcentageJeune() {
        return pourcentageJeune;
    }

    public void setPourcentageJeune(double pourcentageJeune) {
        this.pourcentageJeune = pourcentageJeune;
    }

    public double getPourcentageVieux() {
        return pourcentageVieux;
    }

    public void setPourcentageVieux(double pourcentageVieux) {
        this.pourcentageVieux = pourcentageVieux;
    }

    public double getGetPourcentageAdulte() {
        return getPourcentageAdulte;
    }

    public void setGetPourcentageAdulte(double getPourcentageAdulte) {
        this.getPourcentageAdulte = getPourcentageAdulte;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


    public double getPourcentageTotal() {
        return pourcentageTotal;
    }

    public void setPourcentageTotal(double pourcentageTotal) {
        this.pourcentageTotal = pourcentageTotal;
    }

    public  void calcul(Candidate candidate)
     {


        int totalP = candidate.getResultat().getResultatFinal();
         double pcFemme = (double) ((candidate.getResultat().getResultatParGenderFemme()) / totalP) ;

         double pcHomme =  (double)(candidate.getResultat().getResultatParGnederHomme())/ totalP ;
         double pcJeune  = (double) (candidate.getResultat().getResultatParAgeJeune())/ totalP ;
         double pcAdult = (double)(candidate.getResultat().getResultatparAgeMoyen())/ totalP ;
         double pcVieux =  (double) (candidate.getResultat().getResultatparAgeVieux())/ totalP ;
        this.setTotal(totalP);
        this.setCandidate(candidate);
        this.setPourcentageFemme(pcFemme);
        this.setPourcentageHomme(pcHomme);
        this.setPourcentageJeune(pcJeune);
        this.setGetPourcentageAdulte(pcAdult);
        this.setPourcentageVieux(pcVieux);
     }

}
