package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.model.Coordinateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateurRepository extends JpaRepository <Coordinateur , Long> {
}
