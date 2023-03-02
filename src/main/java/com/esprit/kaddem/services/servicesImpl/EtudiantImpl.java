package com.esprit.kaddem.services.servicesImpl;

import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Department;
import com.esprit.kaddem.entities.Equipe;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.repositories.EtudiantRepository;
import com.esprit.kaddem.services.ContratService;
import com.esprit.kaddem.services.DepartmentService;
import com.esprit.kaddem.services.EquipeService;
import com.esprit.kaddem.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EtudiantImpl implements EtudiantService {

    public final EtudiantRepository etudiantRepository;
    public final DepartmentService departmentService;
    public final ContratService contratService;
    public final EquipeService equipeService;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Optional<Etudiant> retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant e = retrieveEtudiant(etudiantId).orElse(null);
        Department d = departmentService.retrieveDepartement(departementId).orElse(null);
        if (e != null && d != null){
            e.setDepartment(d);
            this.updateEtudiant(e);
        }
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Etudiant savedEtudiant = addEtudiant(e);
        Contrat c = contratService.retrieveContrat(idContrat).orElse(null);
        Equipe equipe = equipeService.retrieveEquipe(idEquipe).orElse(null);
        c.setEtudiant(savedEtudiant);
        List<Etudiant> etudiants = equipe.getEtudiants();
        etudiants.add(savedEtudiant);
        equipe.setEtudiants(etudiants);
        equipeService.updateEquipe(equipe);
        contratService.updateContrat(c);
        return savedEtudiant;
    }
}
