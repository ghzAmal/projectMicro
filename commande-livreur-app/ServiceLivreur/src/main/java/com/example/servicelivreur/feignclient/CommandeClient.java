package com.example.servicelivreur.feignclient;

import com.example.servicelivreur.dto.CommandeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "COMMANDESERVICE", url = "http://localhost:9091")
public interface CommandeClient {

    @GetMapping("/commandes/commande/{idLivreur}")
    List<CommandeDTO> getCommandesByLivreur(@PathVariable("idLivreur") String idLivreur);

    @PostMapping("/articles")
    CommandeDTO createCommande(@RequestBody CommandeDTO cmd);
}

