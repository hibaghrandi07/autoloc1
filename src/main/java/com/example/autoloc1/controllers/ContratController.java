
package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Contrat;
import com.example.autoloc1.services.IContratService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@Tag(
        name = "Gestion des Contrats",
        description = "crud"
)
public class ContratController {

    @Autowired
    private IContratService contratService;

    // POST - Ajouter un contrat
    @Operation(
            summary = "Ajouter un contrat",
            description = "Permet de créer un nouveau contrat de location"
    )
    @PostMapping
    public ResponseEntity<Contrat> ajouterContrat(
            @RequestBody Contrat contrat) {

        Contrat nouveau = contratService.ajouterContrat(contrat);

        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    // GET ALL - Consulter tous les contrats
    @Operation(
            summary = "Consulter tous les contrats",
            description = "Retourne la liste de tous les contrats de location"
    )
    @GetMapping
    public ResponseEntity<List<Contrat>> consulterContrats() {

        List<Contrat> contrats = contratService.consultercontrats();

        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    // GET BY ID - Consulter un contrat
    @Operation(
            summary = "Consulter un contrat par ID",
            description = "Recherche un contrat de location à partir de son identifiant"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Contrat> consulterContratById(
            @PathVariable("id") Long id) {

        Contrat contrat = contratService.consulterContratById(id);

        return new ResponseEntity<>(contrat, HttpStatus.OK);
    }

    // PUT - Modifier un contrat
    @Operation(
            summary = "Modifier un contrat",
            description = "Permet de mettre à jour les informations d'un contrat existant"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Contrat> modifierContrat(
            @PathVariable("id") Long id,
            @RequestBody Contrat contrat) {

        contrat.setIdContrat(id);

        Contrat modifie = contratService.modifierContrat(contrat);

        return new ResponseEntity<>(modifie, HttpStatus.OK);
    }

    // DELETE - Supprimer un contrat
    @Operation(
            summary = "Supprimer un contrat",
            description = "Supprime un contrat de location à partir de son identifiant"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerContrat(
            @PathVariable("id") Long id) {

        contratService.supprimerContratById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
