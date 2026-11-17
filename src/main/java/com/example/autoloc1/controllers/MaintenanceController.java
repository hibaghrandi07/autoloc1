
package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Maintenance;
import com.example.autoloc1.services.IMaintenanceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@Tag(name = "Gestion des Maintenances", description = "CRUD")
public class MaintenanceController {

    @Autowired
    private IMaintenanceService maintenanceService;

    // POST - Ajouter une maintenance
    @Operation(summary = "Ajouter une maintenance")
    @PostMapping
    public ResponseEntity<Maintenance> ajouterMaintenance(
            @RequestBody Maintenance maintenance) {

        Maintenance nouvelle = maintenanceService.ajouterMaintenance(maintenance);
        return new ResponseEntity<>(nouvelle, HttpStatus.CREATED);
    }

    // GET ALL - Consulter toutes les maintenances
    @Operation(summary = "Consulter toutes les maintenances")
    @GetMapping
    public ResponseEntity<List<Maintenance>> consulterMaintenances() {

        List<Maintenance> maintenances = maintenanceService.consulterMaintenances();
        return new ResponseEntity<>(maintenances, HttpStatus.OK);
    }

    // GET BY ID - Consulter une maintenance par ID
    @Operation(summary = "Consulter une maintenance par ID")
    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> consulterMaintenanceById(
            @PathVariable("id") Long id) {

        Maintenance maintenance = maintenanceService.consulterMaintenanceById(id);
        return new ResponseEntity<>(maintenance, HttpStatus.OK);
    }

    // PUT - Modifier une maintenance
    @Operation(summary = "Modifier une maintenance")
    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> modifierMaintenance(
            @PathVariable("id") Long id,
            @RequestBody Maintenance maintenance) {

        maintenance.setIdMaintenance(id);
        Maintenance modifiee = maintenanceService.modifierMaintenance(maintenance);
        return new ResponseEntity<>(modifiee, HttpStatus.OK);
    }

    // DELETE - Supprimer une maintenance
    @Operation(summary = "Supprimer une maintenance")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMaintenance(
            @PathVariable("id") Long id) {

        maintenanceService.supprimerMaintenanceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
