package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.Session;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SessionController {

    // TODO ne rajoute pas l'id pour l'édit rest CRUD ok
    //  voir pour les dates validator

    @Autowired
    FicheService ficheService;
    @Autowired
    IntervenantService intervenantService;

    @GetMapping(value = {"/listsessions"})
    public String listeSessions(Model model){
        model.addAttribute("sessionsDTO" , new SessionDTO());
        model.addAttribute("sessions" , ficheService.getTousSessions());
        model.addAttribute("coordinateur" , intervenantService.getAllIntervenantsIntervenant());
        model.addAttribute("formations" , ficheService.getAllFormationsFormation());
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        return "session/list";
    }
    /////// Listes    //////// Ajouter ///////////////////
    @PostMapping("/addSession")
    public String ajouteruneSession(@Validated @ModelAttribute(name ="sessionsDTO")SessionDTO sessionDTO , BindingResult result,RedirectAttributes redirectAttributes, Model model){
        if(result.hasErrors()){
            model.addAttribute("sessions" , ficheService.getTousSessions());
            model.addAttribute("coordinateur" , intervenantService.getAllIntervenantsIntervenant());
            model.addAttribute("formations" , ficheService.getAllFormationsFormation());
            model.addAttribute("centres" , ficheService.getAllCentresCentre());
            return "session/list";
        }

        ficheService.saveSession(sessionDTO);
        model.addAttribute("sessions" , ficheService.getTousSessions());
        model.addAttribute("coordinateur" , intervenantService.getAllIntervenantsIntervenant());
        model.addAttribute("formations" , ficheService.getAllFormationsFormation());
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        redirectAttributes.addFlashAttribute("successMsg" , "La session a bien été enregistrée");
        return "redirect:/listsessions";
    }
    ///////// Supr //////////
    @GetMapping("/session/supr/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id){
        ficheService.deleteSession(id);
        return "redirect:/listsessions";
    }
    //////// Edit ///////////
    @GetMapping("/session/edit/{id}")
    public String UpdateSession(@PathVariable(name = "id") Long id, SessionDTO sessionDTO, Model model) {
        model.addAttribute("session", id);
        Session session = ficheService.getUneSession(id).get();
        sessionDTO = ficheService.convertSessionEntityToDtoSession(session);
        model.addAttribute("sessionsDTO", sessionDTO);
        return "session/edit";
    }
    @PostMapping("session/edit")
    public String updateSession(@ModelAttribute(name ="sessionsDTO")  SessionDTO sessionDTO, RedirectAttributes redirectAttributes, Model model){
        ficheService.updateUneSession(sessionDTO);
        redirectAttributes.addFlashAttribute("successMsg", "La session a bien été modifiée");
        return "redirect:/listsessions";
    }


}
