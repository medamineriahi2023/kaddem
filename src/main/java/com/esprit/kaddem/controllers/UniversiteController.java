package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entities.Universite;
import com.esprit.kaddem.services.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {


    private final UniversiteService universiteService;
    @GetMapping
    public List<Universite> getAll() {
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping
    public Universite add(@RequestBody Universite e) {
        return universiteService.addUniversite(e);
    }

    @PutMapping
    public Universite update (@RequestBody Universite e) {
        return universiteService.updateUniversite(e);
    }

    @GetMapping(path = "/{id}")
    public Universite getById (@PathVariable Integer id) {
        return universiteService.retrieveUniversite(id).orElse(null);
    }

}
