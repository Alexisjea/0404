package com.cda.contenu_seance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FormateurController {
    @GetMapping(value = {"/acceuilformateur"})
    public String index() {
        return "formateur/acceuilformateur";
    }
}
