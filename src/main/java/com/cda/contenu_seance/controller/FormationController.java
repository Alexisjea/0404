package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.model.Formation;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormationController {



    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/listformations"})
    public String listeFormations( Model model){
        model.addAttribute("formationDTO" , new FormationDTO());
        model.addAttribute("formations" , ficheService.getAllFormationsFormation());
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        model.addAttribute("sessions" , ficheService.getTousSessions());
        return "formations/list";
    }
    //Ajouter /////
    @PostMapping("/listformations")
    public String ajouteruneFormation(@Validated @ModelAttribute(name ="formationDTO") FormationDTO formationDTO, BindingResult result, Model model){

        if (result.hasErrors()) {
            model.addAttribute("formations" , ficheService.getAllFormationsFormation());
            return  "formations/list";
        }
        ficheService.saveFormation(formationDTO);
        model.addAttribute("successMsg", "La formation a été ajoutée avec succès");
        model.addAttribute("formations" , ficheService.getAllFormationsFormation());
        return  "formations/list";


    }

    ///// Supprimmer //////
    @GetMapping("/formations/supr/{id}")
    public String suprFormation( @PathVariable(name = "id") Long id,Model model){
        ficheService.deleteFormation(id);
        return "redirect:/listformations";
    }
    /// Modifier /////
    @GetMapping("/formations/edit/{id}")
    public String editerUneFormation(@PathVariable(name = "id") Long id,FormationDTO formationDTO, Model model) {
        model.addAttribute("formation", id);
        Formation formation = ficheService.getFormationById(id).get();
        formationDTO = ficheService.convertFormationEntityToDtoFormation(formation);
        model.addAttribute("formationDTO", formationDTO);
        return "/formations/edit";
    }
    @PostMapping("/traitementFormation")
    public String editerFormation(@Validated @ModelAttribute(name ="formationDTO") @RequestBody FormationDTO formationDTO, BindingResult result , Model model){
        if(result.hasErrors()){
            model.addAttribute("formations", ficheService.getAllFormationsFormation());
            model.addAttribute("formationDTO", new FormationDTO());
            return "formations/list";
        }
        model.addAttribute("formations", ficheService.getAllFormationsFormation());
        ficheService.updateFormation(formationDTO);
        model.addAttribute("successMsg", "La formation a été modifiée avec succès");
        return "formations/list";
    }
}
