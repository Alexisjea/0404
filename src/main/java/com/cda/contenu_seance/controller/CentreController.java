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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CentreController{

    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/listcentres"})
    public String listeCentres(Model model){
        model.addAttribute("centreDTO" , new CentreDTO());
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        model.addAttribute("sessions" , ficheService.getTousSessions());
        model.addAttribute("formation",ficheService.getAllFormationsFormation());

        return "centre/list";
    }
    @PostMapping("/listcentres")
    public String ajouterunCentre(@Validated @ModelAttribute(name ="centreDTO") CentreDTO centreDTO, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            model.addAttribute("centres" , ficheService.getAllCentresCentre());
            model.addAttribute("sessions" , ficheService.getTousSessions());
            model.addAttribute("formation",ficheService.getAllFormationsFormation());
            return  "centre/list";
        }
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        model.addAttribute("sessions" , ficheService.getTousSessions());
        model.addAttribute("formation",ficheService.getAllFormationsFormation());
        ficheService.saveCentre(centreDTO);
        redirectAttributes.addFlashAttribute("successMsg","Le centre a été ajouté avec succès" );
        return "redirect:/listcentres";
    }
    @GetMapping("/centre/supr/{id}")
    public String suprCentre(@PathVariable(name = "id") Long id){
        ficheService.deleteCentre(id);
        return "redirect:/listcentres";
    }
    @GetMapping("/centre/edit/{id}")
    public String editerUnCentre( @PathVariable(name = "id") Long id, CentreDTO centreDTO, Model model) {
        model.addAttribute("toutlescentres" , ficheService.getAllCentresCentre());
        Centre centre = ficheService.getCentre(id).get();
        centreDTO = ficheService.convertCentreEntityToDtoCentre(centre);
        model.addAttribute("centreDTO", centreDTO);
        return "centre/edit";
    }
    @PostMapping("/traitement")
    public String editerCentre(@Validated @ModelAttribute(name ="centreDTO") CentreDTO centreDTO, BindingResult result,RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            model.addAttribute("centres" , ficheService.getAllCentresCentre());
            model.addAttribute("sessions" , ficheService.getTousSessions());
            model.addAttribute("formation",ficheService.getAllFormationsFormation());
            model.addAttribute("centreDTO" , new CentreDTO());
            return  "centre/list";
        }
        model.addAttribute("centres" , ficheService.getAllCentresCentre());
        ficheService.updateCentre(centreDTO);
        redirectAttributes.addFlashAttribute("successMsg","Le centre a été modifié avec succès" );
        return "redirect:/listcentres";
    }
}
