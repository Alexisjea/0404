package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class FormationController {

    // TODO Delete Clef etrangère à faire reste CRUD effectué

    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/listformations"})
    public String listeFormations( Model model){
        model.addAttribute("formation" , new FormationDTO());
        model.addAttribute("formations" , ficheService.getAllFormationsFormation());
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        model.addAttribute("sessions" , ficheService.getAllSessionsSession());
        return "formations/list";
    }
    @PostMapping("/listformations")
    public String addFormation( @ModelAttribute(name ="formation")  @Validated FormationDTO formationDTO){
        ficheService.saveFormation(formationDTO);
        return "redirect:/listformations";
    }
    @GetMapping("/formations/supr/{id}")
    public String deleteFormation( @PathVariable(name = "id") Long id){
        ficheService.deleteFormation(id);
        return "redirect:/listformations";
    }
    @GetMapping("/formations/edit/{id}")
    public String updateForm(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("formation", id);
        return "/formations/edit";
    }
    @PostMapping("/traitementFormation")
    public String updateFormation(@Validated @ModelAttribute(name ="formation") @RequestBody FormationDTO formationDTO){
        ficheService.updateFormation(formationDTO);
        return "redirect:/listformations";
    }
}
