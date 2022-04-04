package com.cda.contenu_seance.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IntervenantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tel;
    private String mp;

}
