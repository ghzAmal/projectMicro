package com.example.serviceLivreur.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class CommandeDTO {
    Long id;
    String reference;
    String description;
    Double montant;
    LocalDateTime dateCommande;
    String statut;
    String idLivreur;
}
