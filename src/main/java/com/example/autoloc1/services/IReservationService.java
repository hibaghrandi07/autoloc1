package com.example.autoloc1.services;

import com.example.autoloc1.domain.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    Reservation modifierReservation(Reservation reservation);
    List<Reservation> consulterReservations();
    Reservation consulterReservationById(Long idReservation);
    void supprimerReservationById(Long idReservation);
}
