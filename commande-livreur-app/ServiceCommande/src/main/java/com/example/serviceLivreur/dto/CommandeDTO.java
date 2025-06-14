package com.example.serviceLivreur.dto;

import java.time.LocalDateTime;

public record CommandeDTO(
        Long id,
        String reference,
        String description,
        Double montant,
        LocalDateTime dateCommande,
        String statut,
        String idLivreur
) {}