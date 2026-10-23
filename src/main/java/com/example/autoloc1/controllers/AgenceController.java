package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Agence;
import com.example.autoloc1.services.IAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    @Autowired
    private IAgenceService agenceService;

    // POST - Ajouter une agence
    @PostMapping
    public ResponseEntity<Agence> ajouterAgence(@RequestBody Agence agence) {
        Agence nouvelle = agenceService.ajouterAgence(agence);
        return new ResponseEntity<>(nouvelle, HttpStatus.CREATED);
    }

    // GET ALL - Consulter toutes les agences
    @GetMapping
    public ResponseEntity<List<Agence>> consulterAgences() {
        List<Agence> agences = agenceService.consulterAgences();
        return new ResponseEntity<>(agences, HttpStatus.OK);
    }

    // GET BY ID - Consulter une agence par ID
    @GetMapping("/{id}")
    public ResponseEntity<Agence> consulterAgenceById(@PathVariable("id") Long id) {
        Agence agence = agenceService.consulterAgenceById(id);
        return new ResponseEntity<>(agence, HttpStatus.OK);
    }

    // PUT - Modifier une agence
    @PutMapping("/{id}")
    public ResponseEntity<Agence> modifierAgence(@PathVariable("id") Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        Agence modifiee = agenceService.modifierAgence(agence);
        return new ResponseEntity<>(modifiee, HttpStatus.OK);
    }

    // DELETE - Supprimer une agence
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAgence(@PathVariable("id") Long id) {
        agenceService.supprimerAgenceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
