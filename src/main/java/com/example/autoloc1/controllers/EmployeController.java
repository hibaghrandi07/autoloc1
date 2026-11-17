package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Employe;
import com.example.autoloc1.services.IEmployeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@Tag(name = "Gestion des Employés", description = "CRUD et affectation des employés")
public class EmployeController {

    @Autowired
    private IEmployeService employeService;

    @Operation(summary = "Ajouter un employé", description = "Crée un nouvel employé")
    @PostMapping
    public ResponseEntity<Employe> ajouterEmploye(@RequestBody Employe employe) {
        Employe nouveau = employeService.ajouterEmploye(employe);
        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    @Operation(summary = "Consulter tous les employés", description = "Retourne la liste des employés")
    @GetMapping
    public ResponseEntity<List<Employe>> consulterEmployes() {
        return new ResponseEntity<>(employeService.consulterEmployes(), HttpStatus.OK);
    }

    @Operation(summary = "Consulter un employé par ID", description = "Recherche un employé par son identifiant")
    @GetMapping("/{id}")
    public ResponseEntity<Employe> consulterEmployeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeService.consulterEmployeById(id), HttpStatus.OK);
    }

    @Operation(summary = "Modifier un employé", description = "Met à jour un employé existant")
    @PutMapping("/{id}")
    public ResponseEntity<Employe> modifierEmploye(@PathVariable("id") Long id,
                                                   @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return new ResponseEntity<>(employeService.modifierEmploye(employe), HttpStatus.OK);
    }

    @Operation(summary = "Supprimer un employé", description = "Supprime un employé par son identifiant")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmploye(@PathVariable("id") Long id) {
        employeService.supprimerEmployeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Désaffecter un employé", description = "Retire l'employé de son agence actuelle")
    @PutMapping("/desaffecter/{idEmploye}")
    public ResponseEntity<Employe> desaffecterEmploye(@PathVariable Long idEmploye) {
        return new ResponseEntity<>(employeService.desaffecterEmploye(idEmploye), HttpStatus.OK);
    }

    @Operation(summary = "Affecter un employé", description = "Affecte l'employé à une agence")
    @PutMapping("/affecter/{idEmploye}/{idAgence}")
    public ResponseEntity<Employe> affecterEmploye(@PathVariable Long idEmploye,
                                                   @PathVariable Long idAgence) {
        return new ResponseEntity<>(employeService.affecterEmploye(idEmploye, idAgence), HttpStatus.OK);
    }
}
