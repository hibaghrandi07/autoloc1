package com.example.autoloc1.services;
import com.example.autoloc1.domain.Maintenance;
import com.example.autoloc1.repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IMaintenanceServiceImp implements IMaintenanceService {
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
    @Override
    public List<Maintenance> consulterMaintenances() {
        return maintenanceRepository.findAll();
    }
    @Override
    public Maintenance consulterMaintenanceById(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance).orElse(null);
    }
    @Override
    public void supprimerMaintenanceById(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }
}
