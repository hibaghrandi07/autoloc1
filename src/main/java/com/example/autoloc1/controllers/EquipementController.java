
package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Equipement;
import com.example.autoloc1.services.IEquipementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@Tag(name = "Gestion des Équipements", description = "CRUD")
public class EquipementController {

    @Autowired
    private IEquipementService equipementService;

    // POST - Ajouter un équipement
    @Operation(summary = "Ajouter un équipement", description = "CRUD")
    @PostMapping
    public ResponseEntity<Equipement> ajouterEquipement(
            @RequestBody Equipement equipement) {

        Equipement nouveau = equipementService.ajouterEquipement(equipement);
        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    // GET ALL - Consulter tous les équipements
    @Operation(summary = "Consulter tous les équipements", description = "CRUD")
    @GetMapping
    public ResponseEntity<List<Equipement>> consulterEquipements() {

        List<Equipement> equipements = equipementService.consulterEquipements();
        return new ResponseEntity<>(equipements, HttpStatus.OK);
    }

    // GET BY ID - Consulter un équipement par ID
    @Operation(summary = "Consulter un équipement par ID", description = "CRUD")
    @GetMapping("/{id}")
    public ResponseEntity<Equipement> consulterEquipementById(
            @PathVariable("id") Long id) {

        Equipement equipement = equipementService.consulterEquipementById(id);
        return new ResponseEntity<>(equipement, HttpStatus.OK);
    }

    // PUT - Modifier un équipement
    @Operation(summary = "Modifier un équipement", description = "CRUD")
    @PutMapping("/{id}")
    public ResponseEntity<Equipement> modifierEquipement(
            @PathVariable("id") Long id,
            @RequestBody Equipement equipement) {

        equipement.setIdEquipement(id);
        Equipement modifie = equipementService.modifierEquipement(equipement);
        return new ResponseEntity<>(modifie, HttpStatus.OK);
    }

    // DELETE - Supprimer un équipement
    @Operation(summary = "Supprimer un équipement", description = "CRUD")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEquipement(
            @PathVariable("id") Long id) {

        equipementService.supprimerEquipementById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
