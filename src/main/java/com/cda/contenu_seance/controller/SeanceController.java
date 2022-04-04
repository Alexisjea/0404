package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.model.Seance;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SeanceController {

    @Autowired
    FicheService ficheService;

    @Autowired
    IntervenantService intervenantService;

    @GetMapping(value = {"/listseances"})
    public String listseances(Model model) {

        List <Seance> seances = ficheService.getAllSeancesSeance();
        model.addAttribute("seancegretas" ,seances);

        return "seance/list";
    }
    @PostMapping("/addseance")
    public String addSeance(@ModelAttribute(name ="seancegretas")  @Validated SeanceDTO seanceDTO){
//        if (result.hasErrors()) {
//            return "errors/addFormation";
//        }
        ficheService.saveSeance(seanceDTO);
        return "redirect:/listseances";
    }

}
