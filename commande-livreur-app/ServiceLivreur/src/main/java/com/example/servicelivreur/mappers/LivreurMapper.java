package com.example.servicelivreur.mappers;

import com.example.servicelivreur.dto.LivreurDTO;
import com.example.servicelivreur.entities.Livreur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LivreurMapper {
    Livreur mapToEntity(LivreurDTO livreurDto);
    LivreurDTO mapToDto(Livreur livreur);
}