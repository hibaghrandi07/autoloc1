package com.example.autoloc1.services;
import com.example.autoloc1.domain.Contrat;
import java.util.List;
public interface IContratService {Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat(Contrat contrat);
    List<Contrat>consultercontrats();
    Contrat consulterContratById(Long idContrat);
    void supprimerContratById(Long idContrat);

}


