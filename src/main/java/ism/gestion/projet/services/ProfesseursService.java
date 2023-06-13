package ism.gestion.projet.services;

import ism.gestion.projet.api.dto.ProfesseurDto;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProfesseursService implements IProfesseurService {
    @Autowired
    ProfesseurRepository professeurRepository;
    /**
     * @return
     */
    @Override
    public List<Professeur> getAllProfesseur() {
        return professeurRepository.findAll();
    }

    /**
     * @param professeur
     * @return
     */
    @Override
    public Professeur AddProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }
}
