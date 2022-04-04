package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CoordinateurDTO {
    private Long id;
    private List<Centre> centres;
    private List <Session> sessions;
}
