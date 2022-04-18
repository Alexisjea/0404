package com.cda.contenu_seance.controller;

import com.cda.contenu_seance.dto.FormationDTO;
import com.cda.contenu_seance.dto.SeanceDTO;
import com.cda.contenu_seance.dto.SessionDTO;
import com.cda.contenu_seance.model.Seance;
import com.cda.contenu_seance.services.FicheService;
import com.cda.contenu_seance.services.IntervenantService;
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
import java.util.List;
// TODO terminer le formulaire pour que le validator passe
//  terrminer le edit cotté thymeleaf
//
@Controller
public class SeanceController {

    @Autowired
    FicheService ficheService;
    @GetMapping(value = {"/listseances"})
    public String listseances(Model model) {
        model.addAttribute("seanceDTO" , new SeanceDTO());
        model.addAttribute("seancegretas" ,ficheService.getAllSeancesSeance());
        return "seance/list";
    }
    @PostMapping("/addseance")
    public String ajouterSeance(@Validated @ModelAttribute(name ="seanceDTO")SeanceDTO seanceDTO, BindingResult result,RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            model.addAttribute("seancegretas" ,ficheService.getAllSeancesSeance());
            return "seance/list";
        }
        ficheService.saveSeance(seanceDTO);
        model.addAttribute("seancegretas" ,ficheService.getAllSeancesSeance());
        redirectAttributes.addFlashAttribute("successMsg","La séance a été ajouté avec succès" );
        return "redirect:/listseances";
    }
    @GetMapping("/seance/supr/{id}")
    public String deleteSeance(@PathVariable(name = "id") Long id){
        ficheService.deleteSeance(id);
        return "seance/list";
    }
    /// Modifier ////
    @GetMapping("seance/edit/{id}")
    public String updateUneSeance(@PathVariable(name = "id") Long id , SeanceDTO seanceDTO, Model model){
       model.addAttribute("seance", id);
       Seance seance = ficheService.getSeance(id).get();
       seanceDTO = ficheService.convertSeanceEntityToDtoSeance(seance);
       model.addAttribute("seanceDTO", seanceDTO);
       return "seance/edit";
    }
    @PostMapping("traitementSeances")
    public String updateSeance(@ModelAttribute(name = "seanceDTO") SeanceDTO seanceDTO,RedirectAttributes redirectAttributes,Model model){
        ficheService.updateSeance(seanceDTO);
        redirectAttributes.addFlashAttribute("successMsg", "La séance a été modifée avec succès");
        return "redirect:/listseances";
    }

}
