package com.example.servicecommande.services;

import com.example.servicecommande.dto.CommandeDTO;

import java.util.List;
import java.util.Map;

public interface ICommandeService {

    CommandeDTO add(CommandeDTO articleDto);

    CommandeDTO update(Long idArticle, Map<Object, Object> fields);  // ID changé en Long

    boolean delete(Long idArticle);  // ID changé en Long

    List<CommandeDTO> getCommandes();

    CommandeDTO getCommandeById(Long id);
}
