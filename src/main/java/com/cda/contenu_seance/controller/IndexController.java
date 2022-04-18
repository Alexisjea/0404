package com.cda.contenu_seance.controller;
//import com.cda.contenu_seance.services.GretaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
    @GetMapping(value = {"/"})
    public String index() {
        return "formateur/index";
    }

    @GetMapping(value = {"/dashboard"})
    public String test() {
        return "dashboard/index";
    }

}



