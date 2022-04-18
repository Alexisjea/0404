package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Seance;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Getter
@Setter
public class CompetenceDTO {
    private Long id;
    @NotEmpty(message = "Le nom de la compétence doit être renseignée")
    private String nom;
    @NotNull(message = "Le numéro de la compétence doit être renseignée")
    private int numFicheCompetence;
    private Activite activite;
    private Set<Seance> seances;
}
