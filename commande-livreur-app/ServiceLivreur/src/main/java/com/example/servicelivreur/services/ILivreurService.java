package com.example.servicelivreur.services;

import com.example.servicelivreur.dto.LivreurDTO;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ILivreurService {

    LivreurDTO add(LivreurDTO livreurDto);

    LivreurDTO update(String id, Map<Object,Object> fields);

    boolean delete(String id);

    Page<LivreurDTO> getLivreurs(int pageNbr, int pageSize);

    LivreurDTO getLivreur(String id);

    LivreurDTO getLivreurByNom(String nom);
}