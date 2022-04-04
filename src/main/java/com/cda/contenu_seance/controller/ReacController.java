package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping(value = "/Coordinateur")
public class ReacController {



    @Autowired
    ReferentielService referentielService;

    @Autowired
    FicheService ficheService;

    @GetMapping(value = {"/listreac"})
    public String listeReacs(Model model){
        model.addAttribute("reac" , new ReacDTO());
        model.addAttribute("reacs" , referentielService.getAllReacs());
        model.addAttribute("formationAll", ficheService.getAllFormationsFormation());

        return "reac/list";
    }
    @PostMapping("/addReac")
    public String ajouterunReac(@ModelAttribute(name ="reacs") ReacDTO reacDTO){
        referentielService.saveReac(reacDTO);
        return "redirect:/Coordinateur/listreac";
    }
    @GetMapping("reac/supr/{id}")
    public String deleteReac(@PathVariable(name = "id") Long id){
        referentielService.deleteReac(id);
        return "redirect:/Coordinateur/listreac";
    }
    @GetMapping("reac/edit/{id}")
    public String updateUnReac(@PathVariable(name = "id") Long id ,Model model) {
        model.addAttribute("reac",id);
        return "reac/edit";
    }
    @PostMapping("traitementReac")
    public String updateReac(@ModelAttribute(name = "reac") ReacDTO reacDTO){
        referentielService.updateUnReac(reacDTO);
        return "redirect:/Coordinateur/listreac";
    }
}
