package com.example.autoloc1.services;
import com.example.autoloc1.domain.Employe;
import com.example.autoloc1.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IEmployeServiceImp implements IEmployeService {
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
    @Override
    public List<Employe> consulterEmployes() {
        return employeRepository.findAll();
    }
    @Override
    public Employe consulterEmployeById(Long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }
    @Override
    public void supprimerEmployeById(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }
}
