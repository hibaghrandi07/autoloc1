package com.example.autoloc1.services;
import com.example.autoloc1.domain.Reservation;
import com.example.autoloc1.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IReservationServiceImp implements IReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> consulterReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation consulterReservationById(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
    @Override
    public void supprimerReservationById(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}
