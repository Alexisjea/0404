package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.repositories.CentreRepository;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CentreController {

    @Autowired
    FicheService ficheService;

    @PostMapping("/listcentres")
    public String ajouterunCentre(@ModelAttribute(name ="centre") CentreDTO centreDTO){
        ficheService.saveCentre(centreDTO);
        return "redirect:/listcentres";
    }
    @GetMapping(value = {"/listcentres"})
    public String listeCentres(Model model){
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        model.addAttribute("sessions" , ficheService.getAllSessionsSession());
        model.addAttribute("formation",ficheService.getAllFormationsFormation());
        model.addAttribute("centre" , new CentreDTO());
        return "centre/list";
    }

    @GetMapping("/centre/supr/{id}")
    public String deleteCentre(@PathVariable(name = "id") Long id){
        ficheService.deleteCentre(id);
        return "redirect:/listcentres";
    }
    @GetMapping("/centre/edit/{id}")
    public String showUpdateForm(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("centre", id);
        model.addAttribute("formations",id);
        model.addAttribute("sessionss", id);
        return "centre/edit";
    }
    @PostMapping("/traitement")
    public String updateCentre(@ModelAttribute(name ="centre") CentreDTO centreDTO, FormationDTO formationDTO, Model model){
        ficheService.updateCentre(centreDTO);
        return "redirect:/listcentres";
    }
}
