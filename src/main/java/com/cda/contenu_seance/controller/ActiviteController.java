package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.ActiviteDTO;
import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.services.ReferentielService;
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
public class ActiviteController {
    @Autowired
    private ReferentielService referentielService;

    @GetMapping(value = "/listactivites")
    public String listActivites(Model model){
        model.addAttribute("activiteDTO" , new ActiviteDTO());
        model.addAttribute("competence", referentielService.getAllCompetences());
        model.addAttribute("activites" , referentielService.getAllActivite());
        model.addAttribute("reac" , referentielService.getAllReacs());
        return "activites/list";
   }
   //// Ajouter /////
    @PostMapping("/listactivites")
    public String ajouteruneActivite(@Validated @ModelAttribute(name ="activiteDTO") ActiviteDTO activiteDTO, RedirectAttributes redirectAttributes, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("competence", referentielService.getAllCompetences());
            model.addAttribute("activites" , referentielService.getAllActivite());
            model.addAttribute("reac" , referentielService.getAllReacs());
            return "activites/list";
        }
        model.addAttribute("activites", referentielService.getAllActivite());
        referentielService.saveActivite(activiteDTO);
        redirectAttributes.addFlashAttribute("successMsg","Le centre a été ajouté avec succès" );
        return "redirect:/listactivites";

    }
    ////SUPRIMMER //////
    @GetMapping("/activites/supr/{id}")
    public String deleteActivites(@PathVariable(name = "id") Long id){
        referentielService.deleteActivite(id);
        return "redirect:/listactivites";
    }
    /// Modifier /////
    @GetMapping("/activites/edit/{id}")
    public String UpdateForm(@PathVariable(name = "id") Long id,ActiviteDTO activiteDTO, Model model) {
       model.addAttribute("activite", id);
        Activite activite = referentielService.getActiviteById(id);
        activiteDTO = referentielService.convertActiviteEntityToDto(activite);
        model.addAttribute("activiteDTO", activiteDTO);

        return "/activites/edit";
    }
    @PostMapping("/traitementActivites")
    public String updateActivite(@ModelAttribute(name ="activiteDTO") ActiviteDTO activiteDTO,Model model){
        model.addAttribute("activites", referentielService.getAllActivite());
        referentielService.updateActivite(activiteDTO);
        model.addAttribute("successMsg", "L'activité a été modifiée avec succès");
        return "activites/list";
    }

}
