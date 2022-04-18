package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/Coordinateur")
public class CompetenceController {

    @Autowired
    ReferentielService referentielService;

    @Autowired
    FicheService ficheService;

    @GetMapping("/Competences")
    public String getAllCompetences(Model model){
        model.addAttribute("competenceDTO", new CompetenceDTO());
        model.addAttribute("competences" , referentielService.getAllCompetences());
        model.addAttribute("activites" , referentielService.getAllActivite());
        model.addAttribute("formations",ficheService.getAllFormationsFormation());
        model.addAttribute("seances",ficheService.getAllSeancesSeance());
        return "competence/list";
    }
    @PostMapping("/addCompetence")
    public String addCompetences(@Validated @ModelAttribute(name = "competenceDTO") CompetenceDTO competenceDTO, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("competences" , referentielService.getAllCompetences());
            return "competence/list";
        }

        referentielService.saveCompetence(competenceDTO);
        model.addAttribute("successMsg", "La compétence a été ajoutée avec succès");
        model.addAttribute("competences" , referentielService.getAllCompetences());
        return "competence/list";
    }
    @GetMapping("Competences/{id}")
    public String suprCompetence(@PathVariable(name = "id") Long id){
        referentielService.deleteCompetence(id);
        return "redirect:/Coordinateur/Competences";
    }
    @GetMapping("Competences/edit/{id}")
    public String updateCompetence(@PathVariable(name = "id") Long id,CompetenceDTO competenceDTO, Model model){
        model.addAttribute("competence" ,id);
        model.addAttribute("activites" , referentielService.getAllActivite());
        Competence competence = referentielService.getCompetence(id).get();
        competenceDTO = referentielService.convertCompetenceEntityToDtoCompetence(competence);
        model.addAttribute("competenceDTO" , competenceDTO);
        return "competence/edit";
    }
    @PostMapping("updateCompetence")
    public String updatecompetence(@ModelAttribute(name="competenceDTO")CompetenceDTO competenceDTO, RedirectAttributes redirectAttributes, Model model){
        model.addAttribute("competences", referentielService.getAllCompetences());
        referentielService.updateCompetence(competenceDTO);
        redirectAttributes.addFlashAttribute("successMsg", "La compétence a bien été modifiée");
        // model.addAttribute("successMsg", "La compétence a été modifiée avec succès");
        return "redirect:/Coordinateur/Competences";
    }

}
