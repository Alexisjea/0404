package com.cda.contenu_seance.dto;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Reac;
import com.cda.contenu_seance.model.Session;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
public class FormationDTO {

    private Long id;
    @NotEmpty
    @NotBlank(message = "ne peut pas etre vide CACACACACCAACCACAACCACACACAC")
    @Size(min = 3, message = "plus de 3 caracteres")
    private String typeFormation;
    private Centre centre;
    private List<Session> sessions;
    private List<Reac> reacs;
}
