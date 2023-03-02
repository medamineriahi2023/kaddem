package com.esprit.kaddem.services;

import com.esprit.kaddem.entities.Equipe;

import java.util.List;
import java.util.Optional;


public interface EquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Optional<Equipe> retrieveEquipe (Integer idEquipe);

    void deleteEquipe (Integer idEquipe);


}
