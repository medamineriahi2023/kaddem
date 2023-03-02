package com.esprit.kaddem.services.servicesImpl;

import com.esprit.kaddem.entities.Equipe;
import com.esprit.kaddem.repositories.EquipeRepository;
import com.esprit.kaddem.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeImpl implements EquipeService {


    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Optional<Equipe> retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe);
    }

    @Override
    public void deleteEquipe(Integer idEquipe) {
    equipeRepository.deleteById(idEquipe);
    }

}
