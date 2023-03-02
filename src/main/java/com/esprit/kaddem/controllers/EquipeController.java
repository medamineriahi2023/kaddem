package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Equipe;
import com.esprit.kaddem.services.EquipeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {


    private final EquipeService equipeService;
    @GetMapping
    public List<Equipe> getEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @PostMapping
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeService.addEquipe(e);
    }

    @PutMapping
    public Equipe updateEquipe (@RequestBody Equipe e) {
        return equipeService.updateEquipe(e);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEquipe (@PathVariable Integer id) {
        equipeService.deleteEquipe(id);
    }

    @GetMapping(path = "/{id}")
    public Equipe getById(@PathVariable Integer id) {
        return equipeService.retrieveEquipe(id).orElse(null);
    }


}
