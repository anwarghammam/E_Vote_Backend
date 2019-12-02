package com.example.demo.repositories;

import com.example.demo.Models.Candidate;
import com.example.demo.Models.Resultat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultatRepo  extends  MongoRepository<Resultat, String>  {
 Resultat findResultatById(String resId );
}

