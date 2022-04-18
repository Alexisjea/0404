package com.cda.contenu_seance.services;

import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.Session;
import com.cda.contenu_seance.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GretaServiceTest {

    @Autowired
    private ReferentielService referentielService;
    private FicheService ficheService;
    private IntervenantService intervenantService;

  //  @Autowired
  //  private FormateurDTO formateurDTO;

    @Autowired
    private SessionRepository sessionRepository;

    @Test
    void getAllActivitesActivite() {

    }
    @Test
    public void initOK() {


    }


    @Test
    void deleteActivite() {
    }

    @Test
    void testDeleteActivite() {
    }

    @Test
    void getAllIntervenantsIntervenant() {


    }

    @Test
    void getIntervenant() {
    }

    @Test
    void deleteIntervenant() {
    }

    @Test
    void testDeleteIntervenant() {
    }

    @Test
    void getAllCentresCentre() {
    }

    @Test
    void deleteCentre() {
    }

    @Test
    void testDeleteCentre() {
    }

    @Test
    void getAllCompetencesCompetence() {
    }

    @Test
    void deleteCompetence() {
    }

    @Test
    void testDeleteCompetence() {
    }

    @Test
    void getAllFormateursFormateur() {





    }
    @Test
    void  getFormateur(){

    }




    @Test
    void deleteFormateur() {
    }

    @Test
    void testDeleteFormateur() {
    }

    @Test
    void getAllFormationsFormation() {
    }

    @Test
    void deleteFormation() {
    }

    @Test
    void testDeleteFormation() {
    }

    @Test
    void getAllReacsReac() {
    }

    @Test
    void deleteReac() {
    }

    @Test
    void testDeleteReac() {
    }

    @Test
    void getAllSeancesSeance() {
    }

    @Test
    void deleteSeance() {
    }

    @Test
    void testDeleteSeance() {
    }


//    @Test
//    @Transactional
//    void getAllSessionsSession() {
//      List <SessionDTO> session =  ficheService.getAllSessionsSession();
//        assertEquals(session ,ficheService.getAllSessionsSession());
//    }

    @Test
    @Transactional
    void deleteSession()  {
        sessionRepository.deleteById(1L);
        assertTrue(sessionRepository.findById(1L).isEmpty());

    }
//    @Test
//    @Transactional
//    void deleteSession1()  {
//        ficheService.deleteSession(1L);
//        assertEquals(ficheService.getSession(1L));
//
//    }

    private void assertEquals(Session session) {
    }

//    private void assertEquals(Session session) {
//    }



    @Test
    void testDeleteSession() {
    }
}