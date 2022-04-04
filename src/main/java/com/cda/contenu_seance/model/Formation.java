/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
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

public class Formation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeFormation;
//    @ManyToMany
//    private List<Activiter> referencielActiviter;

    @OneToMany(mappedBy = "formation")
    private List <Session> sessions;
    @OneToMany(mappedBy = "formation")

    private List<Reac> reacs;


    public Formation(String typeFormation , Session sessions) {
        this.typeFormation = typeFormation;

    }
}