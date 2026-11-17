package com.example.autoloc1.services;

import com.example.autoloc1.domain.Agence;
import com.example.autoloc1.domain.Vehicule;

import com.example.autoloc1.repositories.AgenceRepository;
import com.example.autoloc1.repositories.VehiculeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IAgenceServiceImp implements IAgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;

    // 1. Ajouter une agence
    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    // 2. Modifier une agence
    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    // 3. Consulter toutes les agences
    @Override
    public List<Agence> consulterAgences() {
        return agenceRepository.findAll();
    }

    // 4. Consulter une agence par ID
    @Override
    public Agence consulterAgenceById(Long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    // 5. Supprimer une agence
    @Override
    public void supprimerAgenceById(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    // 6. Créer une agence avec deux véhicules
    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {

        if (agence.getVehicules() == null
                || agence.getVehicules().size() != 2) {
            throw new IllegalArgumentException(
                    "Il faut fournir exactement deux véhicules"
            );
        }

        // Récupérer les deux véhicules
        List<Vehicule> vehicules =
                new ArrayList<>(agence.getVehicules());

        // Enregistrer d'abord l'agence
        agence.setVehicules(null);

        Agence nouvelleAgence = agenceRepository.save(agence);

        // Affecter et enregistrer les véhicules
        for (Vehicule vehicule : vehicules) {

            vehicule.setAgence(nouvelleAgence);

            vehiculeRepository.save(vehicule);
        }

        // Retourner l'agence créée
        return nouvelleAgence;
    }
}