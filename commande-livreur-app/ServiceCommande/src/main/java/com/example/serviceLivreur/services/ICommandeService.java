package com.example.serviceLivreur.services;

import com.example.serviceLivreur.dto.CommandeDTO;

import java.util.List;
import java.util.Map;

public interface ICommandeService {

    CommandeDTO add(CommandeDTO cmd);

    CommandeDTO update(Long idcmd, Map<Object, Object> fields);

    boolean delete(Long idcmd);

    List<CommandeDTO> getCommandes();

    CommandeDTO getCommandeById(Long id);

    CommandeDTO getCommandeByRef(String ref);

}
