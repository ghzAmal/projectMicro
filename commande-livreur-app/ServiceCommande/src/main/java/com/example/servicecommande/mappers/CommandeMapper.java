package com.example.servicecommande.mappers;

import com.example.servicecommande.dto.CommandeDTO;
import com.example.servicecommande.entities.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande mapToEntity(CommandeDTO commandeDTO);
    CommandeDTO mapToDto(Commande marque);
}