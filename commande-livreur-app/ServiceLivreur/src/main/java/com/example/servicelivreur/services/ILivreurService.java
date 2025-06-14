package com.example.serviceLivreur.services;

import com.example.serviceLivreur.dto.CommandeDTO;
import com.example.serviceLivreur.dto.LivreurDTO;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ILivreurService {

    LivreurDTO add(LivreurDTO livreurDto);

    LivreurDTO update(String id, Map<Object,Object> fields);

    boolean delete(String id);

    Page<LivreurDTO> getLivreurs(int pageNbr, int pageSize);

    LivreurDTO getLivreur(String id);

    LivreurDTO getLivreurByNom(String nom);

    void affecterCommande(String nomLivreur , CommandeDTO commande);
}