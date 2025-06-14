package com.example.serviceLivreur.feignclient;

import com.example.serviceLivreur.dto.CommandeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "gateway", url = "http://localhost:8088", path = "/commandes")
public interface CommandeClient {

    @GetMapping("/commande/{idLivreur}")
    List<CommandeDTO> getCommandesByLivreur(@PathVariable("idLivreur") String idLivreur);

    @PostMapping("")
    CommandeDTO createCommande(@RequestBody CommandeDTO cmd);
}

