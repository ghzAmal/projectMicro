package com.example.serviceLivreur.services;

import com.example.serviceLivreur.dto.CommandeDTO;
import com.example.serviceLivreur.dto.LivreurDTO;
import com.example.serviceLivreur.entities.Livreur;
import com.example.serviceLivreur.feignclient.CommandeClient;
import com.example.serviceLivreur.mappers.LivreurMapper;
import com.example.serviceLivreur.repositories.LivreurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LivreurServiceImp implements ILivreurService {

    private final LivreurRepository livreurRepository;
    private final LivreurMapper livreurMapper;
    private final CommandeClient commandeClient;

    @Override
    public LivreurDTO add(LivreurDTO livreurDto) {
        Livreur livreur = livreurMapper.mapToEntity(livreurDto);
        return livreurMapper.mapToDto(livreurRepository.save(livreur));
    }

    @Override
    public LivreurDTO update(String id, Map<Object, Object> fields) {
        Livreur livreur = livreurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livreur not found: " + id));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Livreur.class, (String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, livreur, localDate);
            }else {
                ReflectionUtils.setField(field, livreur, value);
            }

        });
        return livreurMapper.mapToDto(livreurRepository.save(livreur));
    }

    @Override
    public boolean delete(String id) {
        livreurRepository.deleteById(id);
        return livreurRepository.existsById(id);
    }

    @Override
    public Page<LivreurDTO> getLivreurs(int pageNbr, int pageSize) {
        Pageable pageable = PageRequest.of(pageNbr, pageSize);
        Page<Livreur> page = livreurRepository.findAll(pageable);
        List<LivreurDTO> content = page.getContent().stream()
                .map(livreurMapper::mapToDto)
                .toList();
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }


    @Override
    public LivreurDTO getLivreur(String id) {
        return livreurRepository.findById(id)
                .map(livreurMapper::mapToDto)
                .orElseThrow(() -> new IllegalArgumentException("Livreur not found"));
    }

    @Override
    public LivreurDTO getLivreurByNom(String name) {
        return livreurRepository.findByNom(name)
                .map(livreurMapper::mapToDto)
                .orElseThrow(() ->new IllegalArgumentException("Livreur not found with this name"));
    }

    @Override
    public void affecterCommande(String nomLivreur, CommandeDTO commande) {
        LivreurDTO liv =getLivreurByNom(nomLivreur);
        if(liv ==null ){
            throw new IllegalArgumentException("Livreur not found");
        }
        commande.setIdLivreur(liv.id());
        commandeClient.createCommande(commande);
    }


}