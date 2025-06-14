package com.example.serviceLivreur.controllers;

import com.example.serviceLivreur.dto.CommandeDTO;
import com.example.serviceLivreur.dto.LivreurDTO;
import com.example.serviceLivreur.services.ILivreurService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/livreurs")
@RequiredArgsConstructor
public class LivreurRestController {

    private final ILivreurService livreurServiceService;

    @PostMapping
    public LivreurDTO add(@RequestBody LivreurDTO livreurDto) {
        return livreurServiceService.add(livreurDto);
    }

    @PatchMapping("{id}")
    public LivreurDTO patchUpdate(@RequestBody Map<Object,Object> fields, @PathVariable String id){
        return livreurServiceService.update(id,fields);
    }

    @DeleteMapping("{id}")
    public boolean delete( @PathVariable String id){
        return livreurServiceService.delete(id);
    }


    @GetMapping
    public Page<LivreurDTO> getLivreurs(@RequestParam(defaultValue = "0") int pageNbr,
                                       @RequestParam(defaultValue = "10") int pageSize){
        return livreurServiceService.getLivreurs(pageNbr,pageSize);
    }

    @GetMapping("{id}")
    public LivreurDTO getLivreur(@PathVariable String id){
        return livreurServiceService.getLivreur(id);
    }

    @GetMapping("name/{name}")
    public LivreurDTO getLivreurByNom(@PathVariable String name){
        return livreurServiceService.getLivreurByNom(name);
    }

    @PostMapping("affecterCommande/{nameliv}")
    public void affecterCommande(@PathVariable String nameliv,@RequestBody CommandeDTO commande){
         livreurServiceService.affecterCommande(nameliv,commande);
    }


}