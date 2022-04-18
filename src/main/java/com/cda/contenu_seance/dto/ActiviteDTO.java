package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.repositories.ActiviteRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
public class ActiviteDTO {
    private Long id;
    @NotEmpty
    private String activitesTypes;
    @Min(value = 1,message = "Le numéro de la fiche activité type ne commence pas par 0.")
    private int numOrdre;
    private List<Competence> competences;
    private Reac reac;

}
