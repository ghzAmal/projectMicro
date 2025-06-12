package com.example.servicelivreur.repositories;


import com.example.servicelivreur.entities.Livreur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LivreurRepository extends MongoRepository<Livreur, String> {

    Optional<Livreur> findByNom(String nom);
}