package com.example.autoloc1.controllers;

import com.example.autoloc1.domain.Reservation;
import com.example.autoloc1.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    // POST - Ajouter une réservation
    @PostMapping
    public ResponseEntity<Reservation> ajouterReservation(@RequestBody Reservation reservation) {
        Reservation nouvelle = reservationService.ajouterReservation(reservation);
        return new ResponseEntity<>(nouvelle, HttpStatus.CREATED);
    }

    // GET ALL - Consulter toutes les réservations
    @GetMapping
    public ResponseEntity<List<Reservation>> consulterReservations() {
        List<Reservation> reservations = reservationService.consulterReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    // GET BY ID - Consulter une réservation par ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> consulterReservationById(@PathVariable("id") Long id) {
        Reservation reservation = reservationService.consulterReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    // PUT - Modifier une réservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> modifierReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        Reservation modifiee = reservationService.modifierReservation(reservation);
        return new ResponseEntity<>(modifiee, HttpStatus.OK);
    }

    // DELETE - Supprimer une réservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReservation(@PathVariable("id") Long id) {
        reservationService.supprimerReservationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
