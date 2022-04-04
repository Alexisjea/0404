package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CompetenceDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/Coordinateur")
public class CompetenceController {

    @Autowired
    ReferentielService referentielService;

    @Autowired
    FicheService ficheService;

    @GetMapping("/Competences")
    public String getAllCompetences(Model model){
        model.addAttribute("competences" , referentielService.getAllCompetences());
        model.addAttribute("activites" , referentielService.getAllActivite());
        model.addAttribute("formations",ficheService.getAllFormationsFormation());
        model.addAttribute("seances",ficheService.getAllSeancesSeance());
        return "competence/list";
    }
    @PostMapping("/addCompetence")
    public String addCompetences(@ModelAttribute(name = "competences") CompetenceDTO competenceDTO){
        referentielService.saveCompetence(competenceDTO);
        return "redirect:/Coordinateur/Competences";
    }
    @GetMapping("Competences/{id}")
    public String suprCompetence(@PathVariable(name = "id") Long id){
        referentielService.deleteCompetence(id);
        return "redirect:/Coordinateur/Competences";
    }
    @GetMapping("Competences/edit/{id}")
    public String updateCompetence(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("competence" ,id);
        model.addAttribute("activites" , referentielService.getAllActivite());
        return "competence/edit";
    }
    @PostMapping("updateCompetence")
    public String updatecompetence(@ModelAttribute(name="competences")CompetenceDTO competenceDTO){
        referentielService.updateCompetence(competenceDTO);
        return "redirect:/Coordinateur/Competences";
    }

}
