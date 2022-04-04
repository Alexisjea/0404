package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Seance;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FormateurDTO {
    private List<Session> sessions;
    private List<Seance> seances;
}
