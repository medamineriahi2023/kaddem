package com.esprit.kaddem.services;

import com.esprit.kaddem.entities.Contrat;

import java.util.List;
import java.util.Optional;


public interface ContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Optional<Contrat> retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);
}
