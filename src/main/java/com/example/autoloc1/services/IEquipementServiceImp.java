package com.example.autoloc1.services;
import com.example.autoloc1.domain.Equipement;
import com.example.autoloc1.repositories.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IEquipementServiceImp implements IEquipementService {
    @Autowired
    private EquipementRepository equipementRepository;
    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }
    @Override
    public Equipement modifierEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }
    @Override
    public List<Equipement> consulterEquipements() {
        return equipementRepository.findAll();
    }
    @Override
    public Equipement consulterEquipementById(Long idEquipement) {
        return equipementRepository.findById(idEquipement).orElse(null);
    }
    @Override
    public void supprimerEquipementById(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }
}
