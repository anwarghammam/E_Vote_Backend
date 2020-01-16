package com.example.demo.Controller;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Resultat;
import com.example.demo.Models.Statistique;
import com.example.demo.Models.Vote;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vote")
public class ResultatVoteController {
    @Autowired
    private UserRepo userRepo ;
    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    VoteRepo voteRepo ;

    @Autowired
    ResultatRepo resultatRepo ;
    @Autowired
    StatistiqueRepo statistiqueRepo ;
// for admin after end of vote
    @GetMapping("/SortResulatat")
    public List<Candidate> SortesualtatVote(@RequestParam  String idVote)

 {
     Vote vote = voteRepo.findByIdVote(idVote);
     int max = 0 ;
     List<Candidate> candidateList = vote.getListCandidatesParticipents();
       for(int i = 0 ; i <candidateList.size(); i++)
     {
         if(max < candidateList.get(i).getResultat().getResultatFinal()) {
              max =candidateList.get(i).getResultat().getResultatFinal() ;

         }


     }

       System.out.println("++++++++++++++++  resulata :"+max);
        List<Resultat> listResultat = new ArrayList<Resultat>();
        for(int i=0 ; i<candidateList.size() ; i++)
        {
         listResultat .add(candidateList.get(i).getResultat());
        }
   Collections.sort(listResultat ,Collections.reverseOrder()) ;
     System.out.println("++++++++++++++++  sort resultat:");
     List<Candidate> listCanddiateSorted = new ArrayList<Candidate>() ;
     for(int i=0 ; i<listResultat.size() ; i++)
     { System.out.println(listResultat.get(i).getResultatFinal());



         Candidate candidate =  candidateRepo.findByResultat(listResultat.get(i).getId());
         candidate.setRank(i+1);
         candidateRepo.save(candidate);
         listCanddiateSorted.add(candidate);

         System.out.println("canddiate********************** sorted :"+candidate.getCin()+"rank :"+candidateRepo.findByResultat(listResultat.get(i).getId()).getRank()) ;
     }
     vote.setListCandidatesParticipents(listCanddiateSorted);
     voteRepo.save(vote);
     return listCanddiateSorted ;

 }
// for normal user
@GetMapping("/loadResultatVote")
public List<Candidate> loadReultat(@RequestParam String  idVote)
{
    Vote vote = voteRepo.findByIdVote(idVote);
   List<Candidate> l = vote.getListCandidatesParticipents();
   return l ;
}
@GetMapping("/statistiqueCalcul")
public List<Statistique>  statistiqueCalcul(@RequestParam  String idVote)
{
    Vote vote = voteRepo.findByIdVote(idVote);
    List<Candidate> l = vote.getListCandidatesParticipents();
    List<Statistique> statistiques = new ArrayList<Statistique>();
    for(int i =0 ;i< l.size(); i++)
    {
       Statistique statistique = new Statistique();
       statistique.calcul(l.get(i));

       //statistique.setPourcentageTotal();
       statistiqueRepo.save(statistique);

        int totalC= l.get(i).getResultat().getResultatFinal();
        int totalP = vote.getTotalParticipent() ;
        double pourcentageVote = (double)  totalC / totalP ;

        double toto=(double)((int)(pourcentageVote*100))/100;System.out.println("lllllllllllllllllllllllllllllllllllllll"+toto);
        statistique.setPourcentageTotal(toto);
        statistiqueRepo.save(statistique);
        statistiques.add(statistique);
        System.out.println("***************************"+totalC );
        System.out.println("++++++++++++++++++++++++"+totalP);
        System.out.println("***************************"+pourcentageVote );

    }

    return statistiques ;
}
    @GetMapping("/loadStatistique")

    public List<Statistique>  loadStatistique(@RequestParam  String idVote)
    {

       return statistiqueRepo.findAll() ;
    }

    @GetMapping ("/detailsStatistique")
    public  Statistique  detailsStatistique(@RequestParam  String idStatistique)

    {
              Statistique statistique = statistiqueRepo.findByIdStatistique(idStatistique) ;
              System.out.println(statistique.getPourcentageVieux());
                return  statistique ;

    }
@GetMapping("/totalParticipents")
public int  getTotlaPartcipantsVote(@RequestParam  String idVote)
{
     Vote vote = voteRepo.findByIdVote(idVote);

     System.out.println(vote.getTotalParticipent());
    return vote.getTotalParticipent();
}
    @GetMapping("/totalFemmes")
public int getGenralResult(@RequestParam  String idVote)
{
    Vote vote = voteRepo.findByIdVote(idVote);
    List<Candidate> l = vote.getListCandidatesParticipents();
  int nbr = 0 ;
    for(int i =0 ;i< l.size(); i++) {
     nbr  = nbr+ l.get(i).getResultat().getResultatParGenderFemme();

    }
    return  nbr ;
}
    @GetMapping("/totalHommes")
    public int getGenralResultHomme(@RequestParam  String idVote)
    {
        Vote vote = voteRepo.findByIdVote(idVote);
        List<Candidate> l = vote.getListCandidatesParticipents();
        int nbr = 0 ;
        for(int i =0 ;i< l.size(); i++) {
            nbr  = nbr+ l.get(i).getResultat().getResultatParGnederHomme();

        }
        return  nbr ;
    }

    @GetMapping("/totalJeunes")
    public int getGenralResultJeunes(@RequestParam  String idVote)
    {
        Vote vote = voteRepo.findByIdVote(idVote);
        List<Candidate> l = vote.getListCandidatesParticipents();
        int nbr = 0 ;
        for(int i =0 ;i< l.size(); i++) {
            nbr  = nbr+ l.get(i).getResultat().getResultatParAgeJeune();

        }
        return  nbr ;
    }

    @GetMapping("/totalAdultes")
    public int getGenralResultAdults(@RequestParam  String idVote)
    {
        Vote vote = voteRepo.findByIdVote(idVote);
        List<Candidate> l = vote.getListCandidatesParticipents();
        int nbr = 0 ;
        for(int i =0 ;i< l.size(); i++) {
            nbr  = nbr+ l.get(i).getResultat().getResultatparAgeMoyen();

        }
        return  nbr ;
    }

    @GetMapping("/totalVieux")
    public int getGenralResultVieux(@RequestParam  String idVote)
    {
        Vote vote = voteRepo.findByIdVote(idVote);
        List<Candidate> l = vote.getListCandidatesParticipents();
        int nbr = 0 ;
        for(int i =0 ;i< l.size(); i++) {
            nbr  = nbr+ l.get(i).getResultat().getResultatparAgeVieux();

        }
        return  nbr ;
    }
}
