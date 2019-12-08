package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("votes")
public class Vote {

    @Id
    @Indexed
    private String idVote ;

    private Date date_Debut ;
    // lena bech na3arfu ama election presidentielles / legisltaives ect
    private String type ;
    private  Date dateEnd ;
    @DBRef
    List<Candidate> listCandidatesParticipents ;
    private  int totalParticipent ;

    private Boolean activated ;
    public String getIdVote() {
        return idVote;
    }

    public void setIdVote(String idVote) {
        this.idVote = idVote;
    }

    public Vote() {
    }

    public Vote(String idVote, int totalParticipent) {
        this.idVote = idVote;
        this.totalParticipent = totalParticipent;
    }

    public Vote(int totalParticipent) {
        this.totalParticipent = totalParticipent;
    }

    public Vote(String idVote, Date date_Debut, String type, Date dateEnd, List<Candidate> listCandidatesParticipents, int totalParticipent) {
        this.idVote = idVote;
        this.date_Debut = date_Debut;
        this.type = type;
        this.dateEnd = dateEnd;
        this.listCandidatesParticipents = listCandidatesParticipents;
        this.totalParticipent = totalParticipent;
    }


    public Date getDate_Debut() {
        return date_Debut ;
    }

    public void setDate_Debut(Date date_Debut) {
        this.date_Debut = date_Debut;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Candidate> getListCandidatesParticipents() {
        return listCandidatesParticipents;
    }

    public void setListCandidatesParticipents(List<Candidate> listCandidatesParticipents) {
        this.listCandidatesParticipents = listCandidatesParticipents;
    }

    public int getTotalParticipent() {
        return totalParticipent;
    }

    public void setTotalParticipent(int totalParticipent) {
        this.totalParticipent = totalParticipent;
    }

    public Boolean isActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}
