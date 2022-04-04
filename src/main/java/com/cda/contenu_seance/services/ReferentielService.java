package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.repositories.ActiviteRepository;
import com.cda.contenu_seance.repositories.CompetenceRepository;
import com.cda.contenu_seance.repositories.ReacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReferentielService {
    @Autowired
    private ActiviteRepository activiteRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private ReacRepository reacRepository;
    // referenciel service
    //------------------------------ Activite //-----------------------------------------------//

    public void updateActivite(ActiviteDTO activiteDTO){
        Activite  activiteDb = activiteRepository.findById(activiteDTO.getId()).orElse(new Activite());

        activiteDb.setActivitesTypes(activiteDTO.getActivitesTypes());
        activiteDb.setNumOrdre(activiteDTO.getNumOrdre());
        activiteRepository.save(activiteDb);
    }

    public void saveActivite(ActiviteDTO activiteDTO){
        Activite activiteDb;
        if(null == activiteDTO.getId()){
            activiteDb = new Activite();
        }else{
            activiteDb = activiteRepository.findById(activiteDTO.getId()).orElse(new Activite());
        }
        activiteDb.setNumOrdre(activiteDTO.getNumOrdre());
        activiteDb.setActivitesTypes(activiteDTO.getActivitesTypes());
        activiteDb.setCompetences(activiteDTO.getCompetences());
        activiteDb.setReac(activiteDTO.getReac());
        activiteRepository.save(activiteDb);
    }
    public Activite getActiviteById(Long id){
        return activiteRepository.findById(id).orElse(new Activite());
    }
    public List <Activite> getAllActivite(){
        return activiteRepository.findAll();
    }
    //-------------------------Supprimer Activité------------------------//

    public void deleteActivite(long id){
        activiteRepository.deleteById(id);
    }
    public void deleteActivite(Activite activite){
        this.deleteActivite(activite.getId());
    }


    //------------------------------------------Compétence --------------------------------------------------//*

    public List <Competence> getAllCompetences(){
        return competenceRepository.findAll();
    }
    public Competence getCompetence(Long id){
        return competenceRepository.findById(id).orElse(new Competence());
    }

   public void saveCompetence(CompetenceDTO competenceDTO){
        Competence competenceDB;
        if(null == competenceDTO.getId()){
            competenceDB = new Competence();
        }
        else{
            competenceDB = competenceRepository.findById(competenceDTO.getId()).orElse(new Competence());
        }
        competenceDB.setNom(competenceDTO.getNom());
        competenceDB.setNumFicheCompetence(competenceDTO.getNumFicheCompetence());
        competenceDB.setActivite(competenceDTO.getActivite());
        competenceRepository.save(competenceDB);
    }
    public void updateCompetence(CompetenceDTO competenceDTO){
        Competence competenceDB = competenceRepository.findById(competenceDTO.getId()).orElse(new Competence());
        competenceDB.setNom(competenceDTO.getNom());
        competenceDB.setNumFicheCompetence(competenceDTO.getNumFicheCompetence());
        competenceDB.setActivite(competenceDTO.getActivite());
        competenceRepository.save(competenceDB);
    }

    //---------------Suprimmer compétence----------------------------------------//
    public void deleteCompetence(long id){
        competenceRepository.deleteById(id);
    }
    public void deleteCompetence(Competence competence){
        this.deleteCompetence(competence.getId());
    }

//-------------------------------------------Reac-------------------------------------------------------//

    public void saveReac(ReacDTO reacDTO){
        Reac reacDb;
        if(null == reacDTO.getId()){
            reacDb = new Reac();
        }else{
            reacDb = reacRepository.findById(reacDTO.getId()).orElse(new Reac());
        }
        reacDb.setId(reacDTO.getId());
        reacDb.setDateDebut(reacDTO.getDateDebut());
        reacDb.setDuree(reacDTO.getDuree());
        reacDb.setFormation(reacDTO.getFormation());
        reacDb.setLien(reacDTO.getLien());
        reacRepository.save(reacDb);
    }
    public List<Reac> getAllReacs(){return reacRepository.findAll();

    }
    public void updateUnReac(ReacDTO reacDTO){
        Reac reacDB= reacRepository.findById(reacDTO.getId()).orElse(new Reac());
        reacDB.setLien(reacDTO.getLien());
        reacDB.setFormation(reacDTO.getFormation());
        reacDB.setDateDebut(reacDTO.getDateDebut());
        reacDB.setDuree(reacDTO.getDuree());
        reacRepository.save(reacDB);
    }
    //-------------------Suprimmer Reac----------------------------------------//

    public void deleteReac(long id){
        reacRepository.deleteById(id);
    }
    public void deleteReac(Reac reac){
        this.deleteReac(reac.getId());
    }


//    public List<ReacDTO> getAllReacsReac(){
//        return reacRepository.findAll()
//                .stream()
//                .map(ReferentielService::convertReacEntityToDtoReac)
//                .collect(Collectors.toList());
//    }
//
//    private static ReacDTO convertReacEntityToDtoReac(Reac reac){
//        ReacDTO reacDTO = new ReacDTO();
//        reacDTO.setId(reac.getId());
//        reacDTO.setActivites(reac.getActivites());
//        reacDTO.setDateDebut(reac.getDateDebut());
//        reacDTO.setDuree(reac.getDuree());
//        reacDTO.setFormation(reac.getFormation());
//        reacDTO.setLien(reac.getLien());
//
//        return reacDTO;
//
//    }
    //    private static CompetenceDTO convertCompetenceEntityToDtoCompetence(Competence competence){
//        CompetenceDTO competenceDTO = new CompetenceDTO();
//        competenceDTO.setId(competence.getId());
//        competenceDTO.setActivite(competence.getActivite());
//        competenceDTO.setNom(competence.getNom());
//        competenceDTO.setSeances(competence.getSeances());
//
//        return competenceDTO;
//
//    }
//    public List<CompetenceDTO> getAllCompetencesCompetence(){
//        return competenceRepository.findAll()
//                .stream()
//                .map(ReferentielService::convertCompetenceEntityToDtoCompetence)
//                .collect(Collectors.toList());
//    }

//    private static ActiviteDTO convertActiviteEntityToDto(Activite activite){
//        ActiviteDTO activiteDTO = new ActiviteDTO();
//        activiteDTO.setId(activite.getId());
//        activiteDTO.setCompetences(activite.getCompetences());
//       activiteDTO.setActivites(activite.getActivites());
//        activiteDTO.setActivitesTypes(activite.getActivitesTypes());
//        return activiteDTO;
//
//    }


//    public List<ActiviteDTO> getAllActivitesActivite(){
//        return activiteRepository.findAll()
//                .stream()
//                .map(ReferentielService::convertActiviteEntityToDto)
//                .collect(Collectors.toList());
//    }

}
