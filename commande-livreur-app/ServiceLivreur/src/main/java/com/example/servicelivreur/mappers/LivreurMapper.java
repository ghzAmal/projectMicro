package com.example.serviceLivreur.mappers;

import com.example.serviceLivreur.dto.LivreurDTO;
import com.example.serviceLivreur.entities.Livreur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LivreurMapper {
    Livreur mapToEntity(LivreurDTO livreurDto);
    LivreurDTO mapToDto(Livreur livreur);
}