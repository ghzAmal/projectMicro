package com.example.serviceLivreur.repositories;


import com.example.serviceLivreur.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Commande findByReference(String reference);
}
