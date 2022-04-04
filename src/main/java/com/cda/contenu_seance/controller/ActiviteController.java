package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ActiviteController {
    @Autowired
    private ReferentielService referentielService;

    @GetMapping(value = "/listactivites")
    public String listActivites(Model model){
        model.addAttribute("activite" , new ActiviteDTO());
        model.addAttribute("competence", referentielService.getAllCompetences());
        model.addAttribute("activites" , referentielService.getAllActivite());
        model.addAttribute("reac" , referentielService.getAllReacs());
        return "activites/list";
   }
    @PostMapping("/listactivites")
    public String ajouteruneActivite(@ModelAttribute(name ="activite") ActiviteDTO activiteDTO){
        referentielService.saveActivite(activiteDTO);
        return "redirect:/listactivites";
    }
    @GetMapping("/activites/supr/{id}")
    public String deleteActivites(@PathVariable(name = "id") Long id){
        referentielService.deleteActivite(id);
        return "redirect:/listactivites";
    }
    @GetMapping("/activites/edit/{id}")
    public String UpdateForm(@PathVariable(name = "id") Long id, Model model) {
       model.addAttribute("activite", id);
        return "/activites/edit";
    }
    @PostMapping("/traitementActivites")
    public String updateActivite(@ModelAttribute(name ="activite") ActiviteDTO activiteDTO){
        referentielService.updateActivite(activiteDTO);
        return "redirect:/listactivites";
    }

}
