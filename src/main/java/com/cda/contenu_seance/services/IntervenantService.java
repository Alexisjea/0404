package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.dto.FormateurDTO;
import com.cda.contenu_seance.dto.IntervenantDTO;
import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Intervenant;
import com.cda.contenu_seance.repositories.FormateurRepository;
import com.cda.contenu_seance.repositories.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class IntervenantService {


    @Autowired
    private IntervenantRepository intervenantRepository;
    private FormateurRepository formateurRepository;


    //------------------------------ Intervenant //-----------------------------------------------//


    private static IntervenantDTO convertIntervenantEntityToDto(Intervenant intervenant) {
        IntervenantDTO intervenantDTO = new IntervenantDTO();
        intervenantDTO.setId(intervenant.getId());
        intervenantDTO.setNom(intervenant.getNom());
        intervenantDTO.setAdresse(intervenant.getAdresse());
        intervenantDTO.setEmail(intervenant.getEmail());
        intervenantDTO.setMp(intervenant.getMp());
        intervenantDTO.setPrenom(intervenant.getPrenom());
        intervenantDTO.setTel(intervenant.getTel());
        return intervenantDTO;

    }


    public List<IntervenantDTO> getAllIntervenantsIntervenant() {
        return intervenantRepository.findAll()
                .stream()
                .map(IntervenantService::convertIntervenantEntityToDto)
                .collect(Collectors.toList());
    }


    public Intervenant getIntervenant(Long id) {
        return intervenantRepository.findById(id).orElse(new Intervenant() {
        });
    }


    //-------------------------Supprimer Intervenant------------------------//

    public void deleteIntervenant(long id) {
        intervenantRepository.deleteById(id);
    }

    public void deleteIntervenant(Intervenant intervenant) {
        this.deleteIntervenant(intervenant.getId());
    }

    //--------------------------------------------Formateur ---------------------------------------------------//


//    public List<FormateurDTO> getAllFormateursFormateur(long l) {
//        return formateurRepository.findAll()
//                .stream()
//                .map(IntervenantService::convertFormateurEntityToDtoFormateur)
//                .collect(Collectors.toList());
//    }
//
//    private static FormateurDTO convertFormateurEntityToDtoFormateur(Formateur formateur) {
//        FormateurDTO formateurDTO = new FormateurDTO();
//        formateurDTO.setSessions(formateur.getSessions());
//        formateurDTO.setSeances(formateur.getSeances());
//
//        return formateurDTO;
//
//    }
//
//    public Formateur getFormateur(Long id) {
//        return formateurRepository.findById(id).orElse(new Formateur()
//        );
//
//
//    }

    //-------------Suprimmer Formateur----------------------------------------//

    public void deleteFormateur(long id) {
        formateurRepository.deleteById(id);
    }


}