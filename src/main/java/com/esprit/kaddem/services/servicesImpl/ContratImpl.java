package com.esprit.kaddem.services.servicesImpl;

import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Department;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.entities.Universite;
import com.esprit.kaddem.repositories.ContratRepository;
import com.esprit.kaddem.repositories.EtudiantRepository;
import com.esprit.kaddem.repositories.UniversiteRepository;
import com.esprit.kaddem.services.ContratService;
import com.esprit.kaddem.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ContratImpl implements ContratService {
    private final ContratRepository contratRepository;
    private final EtudiantRepository etudiantRepository;
    private final UniversiteRepository universiteRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Optional<Contrat> retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat);
    }

    @Override
    public void removeContrat(Integer idContrat) {
      contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.findByNomAndPrenom(nomE, prenomE).orElse(null);
        Assert.notNull(e, "not null");
        if (e.getContrats().stream().filter(Contrat::getArchive).count() > 5){
            throw new RuntimeException("vous avez dépassé le limite des contrat");
        }
            ce.setEtudiant(e);
            return updateContrat(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.countByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqual(startDate,endDate);
    }


    public boolean validPeriod(Date contractStartDate, Date contractEndDate, Date startDate, Date endDate) {
        return !startDate.before(contractStartDate) && !endDate.after(contractEndDate);
    }



    @Override
    public Map<String, Integer> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate) {
        Universite u = universiteRepository.findById(idUniv).orElse(null);
        Assert.notNull(u,"université not found");
        return u.getDepartments().stream()
                .flatMap(d -> d.getEtudiants().stream())
                .flatMap(etudiant -> etudiant.getContrats().stream())
                .filter(contrat -> !contrat.getArchive() && validPeriod(contrat.getDateDebutContrat(), contrat.getDateFinContrat(), startDate , endDate))
                .sorted(Comparator.comparing(contrat -> contrat.getSpecialite().toString()))
                .collect(Collectors.groupingBy(
                        contrat -> contrat.getSpecialite().toString(),
                        Collectors.summingInt(Contrat::getMontantContrat)
                ));
    }
}
