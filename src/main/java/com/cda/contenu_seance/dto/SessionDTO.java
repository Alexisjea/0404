package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class SessionDTO {
    private Long id;

    @Override
    public String toString() {
        return "SessionDTO{" +
                "dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin ;
    private List<Seance> seances;
    private Centre centre;
    private Formation formation;
    private List <Formateur> formateurs;
    private Coordinateur coordinateur;

}
