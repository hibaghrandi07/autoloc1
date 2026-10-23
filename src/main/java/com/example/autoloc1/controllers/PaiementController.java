package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Paiement;
import com.example.autoloc1.services.IPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private IPaiementService paiementService;

    // POST - Ajouter un paiement
    @PostMapping
    public ResponseEntity<Paiement> ajouterPaiement(@RequestBody Paiement paiement) {
        Paiement nouveau = paiementService.ajouterPaiement(paiement);
        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    // GET ALL - Consulter tous les paiements
    @GetMapping
    public ResponseEntity<List<Paiement>> consulterPaiements() {
        List<Paiement> paiements = paiementService.consulterPaiements();
        return new ResponseEntity<>(paiements, HttpStatus.OK);
    }

    // GET BY ID - Consulter un paiement par ID
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> consulterPaiementById(@PathVariable("id") Long id) {
        Paiement paiement = paiementService.consulterPaiementById(id);
        return new ResponseEntity<>(paiement, HttpStatus.OK);
    }

    // PUT - Modifier un paiement
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> modifierPaiement(@PathVariable("id") Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        Paiement modifie = paiementService.modifierPaiement(paiement);
        return new ResponseEntity<>(modifie, HttpStatus.OK);
    }

    // DELETE - Supprimer un paiement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPaiement(@PathVariable("id") Long id) {
        paiementService.supprimerPaiementById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
