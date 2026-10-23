package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Vehicule;
import com.example.autoloc1.services.IVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    @Autowired
    private IVehiculeService vehiculeService;

    // POST - Ajouter un véhicule
    @PostMapping
    public ResponseEntity<Vehicule> ajouterVehicule(@RequestBody Vehicule vehicule) {
        Vehicule nouveau = vehiculeService.ajouterVehicule(vehicule);
        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    // GET ALL - Consulter tous les véhicules
    @GetMapping
    public ResponseEntity<List<Vehicule>> consulterVehicules() {
        List<Vehicule> vehicules = vehiculeService.consulterVehicules();
        return new ResponseEntity<>(vehicules, HttpStatus.OK);
    }

    // GET BY ID - Consulter un véhicule par ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> consulterVehiculeById(@PathVariable("id") Long id) {
        Vehicule vehicule = vehiculeService.consulterVehiculeById(id);
        return new ResponseEntity<>(vehicule, HttpStatus.OK);
    }

    // PUT - Modifier un véhicule
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> modifierVehicule(@PathVariable("id") Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        Vehicule modifie = vehiculeService.modifierVehicule(vehicule);
        return new ResponseEntity<>(modifie, HttpStatus.OK);
    }

    // DELETE - Supprimer un véhicule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable("id") Long id) {
        vehiculeService.supprimerVehiculeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
