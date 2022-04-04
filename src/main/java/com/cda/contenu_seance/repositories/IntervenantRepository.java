package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.model.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervenantRepository extends JpaRepository <Intervenant, Long> {
}
