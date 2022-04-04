package com.cda.contenu_seance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CoordinateurController {
    @GetMapping(value = {"/acceuilcoordinateur"})
    public String index() {
        return "formateur/acceuilcoordinateur";
    }

}
