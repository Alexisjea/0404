package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SessionController {

    // TODO ne rajoute pas l'id pour l'édit rest CRUD ok
    @Autowired
    FicheService ficheService;
    @Autowired
    IntervenantService intervenantService;


    /////// Listes    //////// Ajouter ///////////////////
    @PostMapping("/listsessions")
    public String ajouteruneSession(@ModelAttribute(name ="session")SessionDTO session){
        ficheService.saveSession(session);
        return "redirect:/listsessions";
    }
    @GetMapping(value = {"/listsessions"})
    public String listeSessions(Model model){
        model.addAttribute("sessionsgreta" , new SessionDTO());
        model.addAttribute("sessions" , ficheService.getAllSessionsSession());
        model.addAttribute("coordinateur" , intervenantService.getAllIntervenantsIntervenant());
        model.addAttribute("formations" , ficheService.getAllFormationsFormation());
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        return "session/list";
    }
    //////// Edit ///////////
    @PostMapping("session/edit")
    public String updateSession(@ModelAttribute(name ="sessionsgreta")  SessionDTO sessionDTO){
        ficheService.saveSession(sessionDTO);
        return "redirect:/listsessions";
    }
    @GetMapping("/session/edit/{id}")
    public String UpdateSession(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("sessionsgreta", id);
        return "session/edit";
    }
    ///////// Supr //////////
    @GetMapping("/session/supr/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id){
        ficheService.deleteSession(id);
        return "redirect:/listsessions";
    }
}
