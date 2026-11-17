
package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Client;
import com.example.autoloc1.services.IClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Gestion des Clients", description = "CRUD")
public class ClientController {

    @Autowired
    private IClientService clientService;

    // POST - Ajouter un client
    @Operation(summary = "Ajouter un client", description = "CRUD")
    @PostMapping
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
        Client nouveau = clientService.ajouterClient(client);
        return new ResponseEntity<>(nouveau, HttpStatus.CREATED);
    }

    // GET ALL - Consulter tous les clients
    @Operation(summary = "Consulter tous les clients", description = "CRUD")
    @GetMapping
    public ResponseEntity<List<Client>> consulterClients() {
        List<Client> clients = clientService.consulterClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    // GET BY ID - Consulter un client par ID
    @Operation(summary = "Consulter un client par ID", description = "CRUD")
    @GetMapping("/{id}")
    public ResponseEntity<Client> consulterClientById(@PathVariable("id") Long id) {
        Client client = clientService.consulterClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // PUT - Modifier un client
    @Operation(summary = "Modifier un client", description = "CRUD")
    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(
            @PathVariable("id") Long id,
            @RequestBody Client client) {

        client.setIdClient(id);
        Client modifie = clientService.modifierClient(client);
        return new ResponseEntity<>(modifie, HttpStatus.OK);
    }

    // DELETE - Supprimer un client
    @Operation(summary = "Supprimer un client", description = "CRUD")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable("id") Long id) {
        clientService.supprimerClientById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
