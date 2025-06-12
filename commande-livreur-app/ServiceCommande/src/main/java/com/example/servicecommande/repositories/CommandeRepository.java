package com.example.servicecommande.repositories;


import com.example.servicecommande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Commande findByReference(String reference);
}
