package com.cda.contenu_seance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//table associative crée avec le ManyToMany
// ManyToMany mappedBy obligatoire peu importe le sens
// OneToMany : quand j'ai une liste = pointer l'attribut de l'enfant avec mappedBy
//
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reac  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lien;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    private Long duree;
    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "reac")
    private List<Activite> activites;

}
