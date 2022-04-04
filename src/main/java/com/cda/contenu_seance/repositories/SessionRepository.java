package com.cda.contenu_seance.repositories;

import com.cda.contenu_seance.model.Centre;
import com.cda.contenu_seance.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository <Session, Long>{
//    @Query("select * from Session where session_id like centre_id ");
//    List<Centre> findByCentreAndId ;
}
