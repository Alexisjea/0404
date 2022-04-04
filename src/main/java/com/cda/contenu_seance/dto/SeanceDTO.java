package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Competence;
import com.cda.contenu_seance.model.Formateur;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SeanceDTO {
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDuJour;
    private int duree;
    private String supportUse;
    private String deroulement;
    private String objectifPeda;
    private Formateur formateur;
    private Session session;
    private Set<Competence> competences;


}
