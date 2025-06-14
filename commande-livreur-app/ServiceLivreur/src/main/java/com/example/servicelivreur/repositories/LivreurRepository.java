package com.example.serviceLivreur.repositories;


import com.example.serviceLivreur.entities.Livreur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LivreurRepository extends MongoRepository<Livreur, String> {

    Optional<Livreur> findByNom(String nom);
}