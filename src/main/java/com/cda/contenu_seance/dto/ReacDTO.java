package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Activite;
import com.cda.contenu_seance.model.Formation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ReacDTO {
    private Long id;
    private String lien;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    private Long duree;
    private Formation formation;
    private List<Activite> activites;
}
