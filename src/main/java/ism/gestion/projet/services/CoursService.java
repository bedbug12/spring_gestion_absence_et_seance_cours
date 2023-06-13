package ism.gestion.projet.services;

import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.repositories.CoursRepository;
import ism.gestion.projet.repositories.EtudiantRepository;
import ism.gestion.projet.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CoursService implements ICoursService{
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    /**
     * @param id
     * @return
     */
    @Override
    public Stream<Integer> nbHeureDerouleRestante(Long id) {
        Cours cours=coursRepository.findById(id).orElseThrow(() -> new RuntimeException("Cours introuvable"));
        int heureRestante=cours.getHeure()-cours.getHeure();
        return Stream.of(cours.getHeure(),heureRestante);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<Cours> listCoursProf(Long id) {
        Professeur professeur=professeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Professeur introuvable"));
        return coursRepository.findByProfesseur(professeur);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<Cours> listCoursEtu(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant introuvable"));
        return coursRepository.findByClasse(etudiant.getClasse());

    }
}
