package com.example.servicelivreur.dto;

import lombok.Data;

@Data
public class CommandeDTO {
    private Long id;
    private String nom;
    private double prix;
    private Long marqueId;
}
