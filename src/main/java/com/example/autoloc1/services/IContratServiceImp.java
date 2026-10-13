package com.example.autoloc1.services;
import com.example.autoloc1.domain.Contrat;
import com.example.autoloc1.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IContratServiceImp implements IContratService {
    @Autowired
    private ContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
    @Override
    public List<Contrat> consultercontrats() {
        return contratRepository.findAll();
    }
    @Override
    public Contrat consulterContratById(Long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }
    @Override
    public void supprimerContratById(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }
}
