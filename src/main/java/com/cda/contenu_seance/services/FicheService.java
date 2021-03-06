package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Formation;
import com.cda.contenu_seance.model.Seance;
import com.cda.contenu_seance.model.Session;
import com.cda.contenu_seance.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FicheService {
    @Autowired
    private FormationRepository formationRepository; //fiche service
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private CentreRepository centreRepository;

    public FicheService(FormationRepository formationRepository,
                        SeanceRepository seanceRepository,
                        SessionRepository sessionRepository,
                        CentreRepository centreRepository ){

        this.formationRepository = formationRepository;
        this.seanceRepository = seanceRepository;
        this.sessionRepository = sessionRepository;
        this.centreRepository = centreRepository;

    }

    //---------------------------------- Centre ---------------------------------------------//

//    private static CentreDTO convertCentreEntityToDtoCentre(Centre centre){
//        CentreDTO centreDTO = new CentreDTO();
//        centreDTO.setId(centre.getId());
//        centreDTO.setNomCentre(centre.getNomCentre());
//        centreDTO.setCodesPostal(centre.getCodesPostal());
//        centreDTO.setAdresseCentre(centre.getAdresseCentre());
//        centreDTO.setVille(centre.getVille());
//        return centreDTO;
//
//    }
    public List<Centre> getAllCentresCentre(){
        return centreRepository.findAll();
    }
    public void saveCentre(CentreDTO centreDTO){
        Centre centreDB;
        if(null == centreDTO.getId()){
            centreDB = new Centre();
        }else{
            centreDB = centreRepository.findById(centreDTO.getId()).orElse(new Centre());
        }
        centreDB.setId(centreDTO.getId());
        centreDB.setAdresseCentre(centreDTO.getAdresseCentre());
        centreDB.setNomCentre(centreDTO.getNomCentre());
        centreDB.setCodesPostal(centreDTO.getCodesPostal());
        centreDB.setVille(centreDTO.getVille());
        //unDto.setSessions(sessionRepository.findById(centreDTO.getSessions()).get());
        // modifier l'affiche si n??cessaire => si un fichier a ??t?? upload??
        centreRepository.save(centreDB);
    }
    public void updateCentre(CentreDTO centreDTO){
        Centre  centreDb = centreRepository.findById(centreDTO.getId()).orElse(null);
        centreDb.setAdresseCentre(centreDTO.getAdresseCentre());
        centreDb.setNomCentre(centreDTO.getNomCentre());
        centreDb.setCodesPostal(centreDTO.getCodesPostal());
        centreDb.setVille(centreDTO.getVille());

        centreRepository.save(centreDb);
    }



    //---------------Suprimmer Centre ---------------------------//

    public void deleteCentre(long id){
        centreRepository.deleteById(id);
    }
    public void deleteCentre(Centre centre){
        this.deleteCentre(centre.getId());
    }


    public Optional<Centre> getCentre(final Long id) {
        return centreRepository.findById(id);
    }



    //---------------------------------------------Formation-----------------------------------------------------//

    private static FormationDTO convertFormationEntityToDtoFormation(Formation formation){
        FormationDTO formationDTO = new FormationDTO();
        formationDTO.setId(formation.getId());
        formationDTO.setTypeFormation(formation.getTypeFormation());
        formationDTO.setReacs(formation.getReacs());
        formationDTO.setSessions(formation.getSessions());
        return formationDTO;

    }

    public List<Formation> getAllFormationsFormation(){
        return formationRepository.findAll();

    }
    public void saveFormation(FormationDTO formationDTO){
        Formation formationDb;
        if(null == formationDTO.getId()){
            formationDb = new Formation();
        }else{
            formationDb = formationRepository.findById(formationDTO.getId()).orElse(new Formation());
        }
        formationDb.setTypeFormation(formationDTO.getTypeFormation());

        formationRepository.save(formationDb);
    }
    public void updateFormation(FormationDTO formationDTO){
        Formation  formationDb = formationRepository.findById(formationDTO.getId()).orElse(null);
        formationDb.setTypeFormation(formationDTO.getTypeFormation());
        formationDb.setReacs(formationDTO.getReacs());
        formationDb.setSessions(formationDTO.getSessions());

        formationRepository.save(formationDb);
    }
    //--------------Suprimmer Formation----------------------------------------//

    public void deleteFormation(long id){
        formationRepository.deleteById(id);
    }
    public void deleteFormation(Formation formation){
        this.deleteFormation(formation.getId());
    }






    //----------------------------------------Seance-----------------------------------------------------------//

    public List<Seance> getAllSeancesSeance(){
        return seanceRepository.findAll();
    }


    private static SeanceDTO convertSeanceEntityToDtoSeance(Seance seance){
        SeanceDTO seanceDTO = new SeanceDTO();
        seanceDTO.setId(seance.getId());

        seanceDTO.setDuree(seance.getDuree());
        seanceDTO.setDeroulement(seance.getDeroulement());
        seanceDTO.setSupportUse(seance.getSupportUse());
        seanceDTO.setDateDuJour(seance.getDateDuJour());
        seanceDTO.setObjectifPeda(seance.getObjectifPeda());
        seanceDTO.setSession(seance.getSession());

        return seanceDTO;

    }
    public void saveSeance(SeanceDTO seanceDTO){
        Seance seanceDb;
        if(null == seanceDTO.getId()){
            seanceDb = new Seance();
        }else{
            seanceDb = seanceRepository.findById(seanceDTO.getId()).orElse(new Seance());
        }

        seanceDb.setDateDuJour(seanceDTO.getDateDuJour());
        seanceDb.setDeroulement(seanceDTO.getDeroulement());
        seanceDb.setDuree(seanceDTO.getDuree());
        // sessionDb.setFormation(sessionRepository.findById(sessionDTO.getId())).get();
       seanceDb.setSupportUse(seanceDTO.getSupportUse());
        // modifier l'affiche si n??cessaire => si un fichier a ??t?? upload??


        seanceRepository.save(seanceDb);
    }

    //----------------Suprimmer Seance----------------------------------------//

    public void deleteSeance(long id){
        seanceRepository.deleteById(id);
    }
    public void deleteSeance(Seance seance){
        this.deleteSeance(seance.getId());
    }






    //----------------------------------------Session----------------------------------------------------------//


    public void saveSession(SessionDTO sessionDTO){
        Session sessionDb;
        if(null == sessionDTO.getId()){
            sessionDb = new Session();
        }else{
            sessionDb = sessionRepository.findById(sessionDTO.getId()).orElse(new Session());
        }

        sessionDb.setDateFin(sessionDTO.getDateFin());
        sessionDb.setDateDebut(sessionDTO.getDateDebut());
        sessionDb.setCentre(sessionDTO.getCentre());
        sessionDb.setFormation(sessionDTO.getFormation());
        sessionDb.setCoordinateur(sessionDTO.getCoordinateur());
        sessionRepository.save(sessionDb);
    }

    public List<SessionDTO> getAllSessionsSession(){
        return sessionRepository.findAll()
                .stream()
                .map(FicheService::convertSessionEntityToDtoSession)
                .collect(Collectors.toList());
    }
    private static SessionDTO convertSessionEntityToDtoSession(Session session){
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setId(session.getId());
        sessionDTO.setCentre(session.getCentre());
        sessionDTO.setDateDebut(session.getDateDebut());
        sessionDTO.setDateFin(session.getDateFin());

        return sessionDTO;

    }
    public Session getSession(Long id){
        return sessionRepository.findById(id).orElse(new Session());
    }



    //-------------Suprimmer Session----------------------------------------//
    public void deleteSession(long id){
        sessionRepository.deleteById(id);
    }
    public void deleteSession(Session session){
        this.deleteSession(session.getId());
    }


    public void findById(Long id) {
    }
}
