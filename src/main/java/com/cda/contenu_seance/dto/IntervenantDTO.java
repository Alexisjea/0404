package com.cda.contenu_seance.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
public class IntervenantDTO {
    private Long id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @NotEmpty
    private String adresse;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String tel;
    @NotEmpty
    private String mp;

}
