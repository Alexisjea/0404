package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.repositories.ActiviteRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ActiviteDTO {
    private Long id;
    private String activitesTypes;
    private int numOrdre;
    private List<Competence> competences;
    private Reac reac;

}
