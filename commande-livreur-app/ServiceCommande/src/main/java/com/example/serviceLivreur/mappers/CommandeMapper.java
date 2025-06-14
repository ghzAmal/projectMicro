package com.example.serviceLivreur.mappers;

import com.example.serviceLivreur.dto.CommandeDTO;
import com.example.serviceLivreur.entities.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande mapToEntity(CommandeDTO commandeDTO);
    CommandeDTO mapToDto(Commande marque);
}