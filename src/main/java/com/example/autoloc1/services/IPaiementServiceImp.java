package com.example.autoloc1.services;
import com.example.autoloc1.domain.Paiement;
import com.example.autoloc1.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IPaiementServiceImp implements IPaiementService {
    @Autowired
    private PaiementRepository paiementRepository;
    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
    @Override
    public Paiement modifierPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
    @Override
    public List<Paiement> consulterPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement consulterPaiementById(Long idPaiement) {
        return paiementRepository.findById(idPaiement).orElse(null);
    }
    @Override
    public void supprimerPaiementById(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }
}
