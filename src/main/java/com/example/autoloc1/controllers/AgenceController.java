package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Agence;
import com.example.autoloc1.services.IAgenceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@Tag(
        name = "Gestion des Agences",
        description = "CRUD et affectation des véhicules aux agences"
)
public class AgenceController {

    @Autowired
    private IAgenceService agenceService;

    // 1. Ajouter une agence
    @Operation(
            summary = "Ajouter une agence",
            description = "Permet de créer une nouvelle agence de location"
    )
    @PostMapping
    public ResponseEntity<Agence> ajouterAgence(
            @RequestBody Agence agence) {

        Agence nouvelle = agenceService.ajouterAgence(agence);

        return new ResponseEntity<>(nouvelle, HttpStatus.CREATED);
    }

    // 2. Consulter toutes les agences
    @Operation(
            summary = "Consulter toutes les agences",
            description = "Retourne la liste de toutes les agences AutoLoc"
    )
    @GetMapping
    public ResponseEntity<List<Agence>> consulterAgences() {

        List<Agence> agences = agenceService.consulterAgences();

        return new ResponseEntity<>(agences, HttpStatus.OK);
    }

    // 3. Consulter une agence par ID
    @Operation(
            summary = "Consulter une agence par ID",
            description = "Recherche une agence à partir de son identifiant"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Agence> consulterAgenceById(
            @PathVariable("id") Long id) {

        Agence agence = agenceService.consulterAgenceById(id);

        return new ResponseEntity<>(agence, HttpStatus.OK);
    }

    // 4. Modifier une agence
    @Operation(
            summary = "Modifier une agence",
            description = "Met à jour une agence existante"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Agence> modifierAgence(
            @PathVariable("id") Long id,
            @RequestBody Agence agence) {

        agence.setIdAgence(id);

        Agence modifiee = agenceService.modifierAgence(agence);

        return new ResponseEntity<>(modifiee, HttpStatus.OK);
    }

    // 5. Supprimer une agence
    @Operation(
            summary = "Supprimer une agence",
            description = "Supprime une agence par son identifiant"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAgence(
            @PathVariable("id") Long id) {

        agenceService.supprimerAgenceById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // 6. Ajouter une agence et lui affecter deux véhicules
    @Operation(
            summary = "Ajouter une agence avec deux véhicules",
            description = "Crée une agence et affecte deux véhicules à cette agence"
    )
    @PostMapping("/ajouter-avec-vehicules")
    public ResponseEntity<Agence> ajouterAgenceEtAffecterVehicules(
            @RequestBody Agence agence) {

        Agence nouvelleAgence =
                agenceService.ajouterAgenceEtAffecterVehicules(agence);

        return new ResponseEntity<>(
                nouvelleAgence,
                HttpStatus.CREATED
        );
    }
}