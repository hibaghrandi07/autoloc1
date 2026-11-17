package com.example.autoloc1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private StatutReservation statut;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservations"})
    private Client client;
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    @JsonIgnoreProperties({"reservations", "maintenances", "equipements"})
    private Vehicule vehicule;
    @OneToOne(mappedBy = "reservation")
    @JsonIgnoreProperties({"reservation"})
    private Contrat contrat;
}
