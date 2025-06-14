package com.example.serviceLivreur.services;

import com.example.serviceLivreur.dto.CommandeDTO;
import com.example.serviceLivreur.mappers.CommandeMapper;
import com.example.serviceLivreur.entities.Commande;
import com.example.serviceLivreur.repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ICommandeServiceImp implements ICommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;

    @Override
    public CommandeDTO add(CommandeDTO cmd) {
        System.out.println("Reçu : " + cmd);
        Commande commande = commandeMapper.mapToEntity(cmd);
        System.out.println("Entité générée : " + commande);
        return commandeMapper.mapToDto(commandeRepository.save(commande));
    }

    @Override
    public CommandeDTO update(Long idCmd, Map<Object, Object> fields) {
        Commande cmd = commandeRepository.findById(idCmd)
                .orElseThrow(() -> new IllegalArgumentException("Commande not found: " + idCmd));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Commande.class, (String) key);
            field.setAccessible(true);

            if(field.getType().equals(LocalDate.class)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Correction du format
                LocalDate localDate = LocalDate.parse((String) value, formatter);
                ReflectionUtils.setField(field, cmd, localDate);
            } else {
                ReflectionUtils.setField(field, cmd, value);
            }
        });
        return commandeMapper.mapToDto(commandeRepository.save(cmd));
    }

    @Override
    public boolean delete(Long idcmd) {
        commandeRepository.deleteById(idcmd);
        return !commandeRepository.existsById(idcmd);
    }

    @Override
    public List<CommandeDTO> getCommandes() {
        List<Commande> commandes = commandeRepository.findAll();
        return commandes.stream().map(commandeMapper::mapToDto).collect(Collectors.toList());
    }


    @Override
    public CommandeDTO getCommandeById(Long id) {
        Commande cmd = commandeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("commande not found with name: " + id));
        return commandeMapper.mapToDto(cmd);  // Conversion de l'entité en DTO
    }

    @Override
    public CommandeDTO getCommandeByRef(String ref) {
        Commande cmd = commandeRepository.findByReference(ref);
       if(cmd == null){
           throw new IllegalArgumentException("commande not found with reference: " + ref);
          }
        return commandeMapper.mapToDto(cmd);
    }
}
