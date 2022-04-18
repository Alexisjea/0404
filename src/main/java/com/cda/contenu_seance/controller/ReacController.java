package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.CentreDTO;
import com.cda.contenu_seance.dto.ReacDTO;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("reacDTO" , new ReacDTO());
        model.addAttribute("reacs" , referentielService.getAllReacs());
        model.addAttribute("formationAll", ficheService.getAllFormationsFormation());

        return "reac/list";
    }
    // Ajouter ////
    @PostMapping("/addReac")
    public String ajouterunReac(@Validated @ModelAttribute(name ="reacDTO") ReacDTO reacDTO, BindingResult result, Model model ){
        if(result.hasErrors()){
            model.addAttribute("reacs", referentielService.getAllReacs());
            return "reac/list";
        }
        referentielService.saveReac(reacDTO);
        model.addAttribute("successMsg", "Reac ajouté avec succès");
        model.addAttribute("reacs" , referentielService.getAllReacs());
        model.addAttribute("formationAll", ficheService.getAllFormationsFormation());
        return "reac/list";
    }
    /// Supprimmer ////
    @GetMapping("reac/supr/{id}")
    public String deleteReac(@PathVariable(name = "id") Long id){
        referentielService.deleteReac(id);
        return "redirect:/Coordinateur/listreac";
    }
    /// Modifier /////
    @GetMapping("reac/edit/{id}")
    public String updateUnReac(@PathVariable(name = "id") Long id, ReacDTO reacDTO,Model model) {
        model.addAttribute("reac",id);
        Reac reac = referentielService.getReacById(id).get();
        reacDTO = referentielService.convertReacEntityToDtoReac(reac);
        model.addAttribute("reactDTO", reacDTO);
        return "reac/edit";
    }
    @PostMapping("traitementReac")
    public String updateReac(@ModelAttribute(name = "reacDTO") ReacDTO reacDTO, Model model){
        model.addAttribute("reacs", referentielService.getAllReacs());
        referentielService.updateUnReac(reacDTO);
        model.addAttribute("successMsg", "Le REAC a été modifiée avec succès");
        return "reac/list";
    }
}
