package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    Integer countByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(Date endDate, Date startDate);
    List<Contrat> findByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(Date endDate, Date startDate);
}
