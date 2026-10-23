package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Maintenance;
import com.example.autoloc1.services.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    @Autowired
    private IMaintenanceService maintenanceService;

    // POST - Ajouter une maintenance
    @PostMapping
    public ResponseEntity<Maintenance> ajouterMaintenance(@RequestBody Maintenance maintenance) {
        Maintenance nouvelle = maintenanceService.ajouterMaintenance(maintenance);
        return new ResponseEntity<>(nouvelle, HttpStatus.CREATED);
    }

    // GET ALL - Consulter toutes les maintenances
    @GetMapping
    public ResponseEntity<List<Maintenance>> consulterMaintenances() {
        List<Maintenance> maintenances = maintenanceService.consulterMaintenances();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    // GET BY ID - Consulter une maintenance par ID
    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> consulterMaintenanceById(@PathVariable("id") Long id) {
        Maintenance maintenance = maintenanceService.consulterMaintenanceById(id);
        return new ResponseEntity<>(maintenance, HttpStatus.OK);
    }

    // PUT - Modifier une maintenance
    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> modifierMaintenance(@PathVariable("id") Long id, @RequestBody Maintenance maintenance) {
        maintenance.setIdMaintenance(id);
        Maintenance modifiee = maintenanceService.modifierMaintenance(maintenance);
        return new ResponseEntity<>(modifiee, HttpStatus.OK);
    }

    // DELETE - Supprimer une maintenance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMaintenance(@PathVariable("id") Long id) {
        maintenanceService.supprimerMaintenanceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
