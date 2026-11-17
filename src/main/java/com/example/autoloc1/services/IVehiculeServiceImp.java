
package com.example.autoloc1.services;

import com.example.autoloc1.domain.Vehicule;
import com.example.autoloc1.domain.Equipement;

import com.example.autoloc1.repositories.VehiculeRepository;
import com.example.autoloc1.repositories.EquipementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
public class IVehiculeServiceImp implements IVehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private EquipementRepository equipementRepository;

    // 1. Ajouter un véhicule
    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // 2. Modifier un véhicule
    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    // 3. Consulter tous les véhicules
    @Override
    public List<Vehicule> consulterVehicules() {
        return vehiculeRepository.findAll();
    }

    // 4. Consulter un véhicule par ID
    @Override
    public Vehicule consulterVehiculeById(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    // 5. Supprimer un véhicule
    @Override
    public void supprimerVehiculeById(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    // 6. Affecter un équipement à un véhicule
    @Override
    @Transactional
    public Vehicule affecterEquipement(
            Long idVehicule, Long idEquipement) {

        // Rechercher le véhicule
        Vehicule vehicule = vehiculeRepository
                .findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Véhicule introuvable"));

        // Rechercher l'équipement
        Equipement equipement = equipementRepository
                .findById(idEquipement)
                .orElseThrow(() ->
                        new RuntimeException("Équipement introuvable"));

        // Initialiser la liste si nécessaire
        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }

        // Vérifier si l'équipement est déjà affecté
        boolean existe = vehicule.getEquipements()
                .stream()
                .anyMatch(e ->
                        idEquipement.equals(e.getIdEquipement()));

        // Ajouter seulement s'il n'existe pas
        if (!existe) {
            vehicule.getEquipements().add(equipement);
        }

        // Enregistrer les modifications
        return vehiculeRepository.save(vehicule);
    }

    // 7. Désaffecter un équipement d'un véhicule
    @Override
    @Transactional
    public Vehicule desaffecterEquipement(
            Long idVehicule, Long idEquipement) {

        // Rechercher le véhicule
        Vehicule vehicule = vehiculeRepository
                .findById(idVehicule)
                .orElseThrow(() ->
                        new RuntimeException("Véhicule introuvable"));

        // Supprimer l'association avec l'équipement
        if (vehicule.getEquipements() != null) {
            vehicule.getEquipements().removeIf(
                    equipement ->
                            idEquipement.equals(
                                    equipement.getIdEquipement()));
        }

        // Enregistrer les modifications
        return vehiculeRepository.save(vehicule);
    }
}
