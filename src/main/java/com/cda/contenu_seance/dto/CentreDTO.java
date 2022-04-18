package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Coordinateur;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@Getter
@Setter
public class CentreDTO {
    private Long id;

    @NotEmpty(message = "Le nom du centre doit être renseigné")
    private String nomCentre;
    @NotEmpty(message = "L'\''adresse du centre doit être renseignée")
    private String adresseCentre;
    @NotEmpty(message = "Le code postal doit être renseigné")
    @Size
    @NotNull
    private String codesPostal;
    @NotEmpty(message = "La ville doit être renseignée")
    private String ville;
    private List<Session> sessions;
    private Coordinateur coordinateur;
}
