package com.example.autoloc1.services;

import com.example.autoloc1.domain.Agence;
import java.util.List;

public interface IAgenceService {

    Agence ajouterAgence(Agence agence);

    Agence modifierAgence(Agence agence);

    List<Agence> consulterAgences();

    Agence consulterAgenceById(Long idAgence);

    void supprimerAgenceById(Long idAgence);

    // Nouvelle méthode : exercice 2
    Agence ajouterAgenceEtAffecterVehicules(Agence agence);
}