package com.example.servicecommande.controllers;

import com.example.servicecommande.dto.CommandeDTO;
import com.example.servicecommande.services.ICommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/commandes")
@RequiredArgsConstructor
public class CommandeRestController {

    private final ICommandeService cmdService;

    @PostMapping
    public CommandeDTO add(@RequestBody CommandeDTO articleDto) {
        return cmdService.add(articleDto);
    }

    @PatchMapping("{id}")
    public CommandeDTO patchUpdate(@RequestBody Map<Object, Object> fields, @PathVariable Long id) {
        return cmdService.update(id, fields);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id) {
        return cmdService.delete(id);
    }

    @GetMapping
    public List<CommandeDTO> getCommandes() {
        return cmdService.getCommandes();  // Pas de pagination, on récupère tous les articles
    }

    @GetMapping("{id}")
    public CommandeDTO getArticle(@PathVariable Long id) {
        return cmdService.getCommandeById(id);
    }

}
