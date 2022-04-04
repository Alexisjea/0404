package com.cda.contenu_seance.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "coordinateur")

public class Coordinateur extends Intervenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "coordinateurs")
    private List<Centre> centres;
    @OneToMany(mappedBy = "coordinateur")
    private List<Session> sessions;


}