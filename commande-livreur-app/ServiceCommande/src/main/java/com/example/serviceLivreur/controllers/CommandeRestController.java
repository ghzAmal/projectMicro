package com.example.serviceLivreur.controllers;

import com.example.serviceLivreur.dto.CommandeDTO;
import com.example.serviceLivreur.services.ICommandeService;
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
    public CommandeDTO add(@RequestBody CommandeDTO cmd) {
        return cmdService.add(cmd);
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
        return cmdService.getCommandes();
    }

    @GetMapping("{id}")
    public CommandeDTO getCommandeById(@PathVariable Long id) {
        return cmdService.getCommandeById(id);
    }

    @GetMapping("{ref}")
    public CommandeDTO getCommandeByRef(@PathVariable String ref) {

        return cmdService.getCommandeByRef(ref);
    }

}
