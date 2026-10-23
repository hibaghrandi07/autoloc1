package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Employe;
import com.example.autoloc1.services.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    @Autowired
    private IEmployeService employeService;

    // POST - Ajouter un employé
    @PostMapping
    public ResponseEntity<Employe> ajouterEmploye(@RequestBody Employe employe) {
        Employe nouveau = employeService.ajouterEmploye(employe);
        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    // GET ALL - Consulter tous les employés
    @GetMapping
    public ResponseEntity<List<Employe>> consulterEmployes() {
        List<Employe> employes = employeService.consulterEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    // GET BY ID - Consulter un employé par ID
    @GetMapping("/{id}")
    public ResponseEntity<Employe> consulterEmployeById(@PathVariable("id") Long id) {
        Employe employe = employeService.consulterEmployeById(id);
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }

    // PUT - Modifier un employé
    @PutMapping("/{id}")
    public ResponseEntity<Employe> modifierEmploye(@PathVariable("id") Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        Employe modifie = employeService.modifierEmploye(employe);
        return new ResponseEntity<>(modifie, HttpStatus.OK);
    }

    // DELETE - Supprimer un employé
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmploye(@PathVariable("id") Long id) {
        employeService.supprimerEmployeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
