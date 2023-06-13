package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.AnneeScolaireDto;
import ism.gestion.projet.api.dto.CoursDto;
import ism.gestion.projet.entities.AnneeScolaire;
import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.repositories.CoursRepository;
import ism.gestion.projet.repositories.EtudiantRepository;
import ism.gestion.projet.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiCoursService implements IApiCoursService {
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    ProfesseurRepository professeurRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    /**
     * @return
     */
    @Override
    public List<CoursDto> getAllCours() {
        return coursRepository.findAll().stream()
                .map(cours -> new CoursDto(cours)).collect(Collectors.toList());
    }

    /**
     * @param cours
     * @return
     */
    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    /**
     * @param id
     * @param cours
     * @return
     */
    @Override
    public Cours updateCours(Long id, Cours cours) {
        Optional<Cours> coursFind=coursRepository.findById(id);
        if (coursFind.isPresent()){
            coursFind.get().setHeure(cours.getHeure());
            coursFind.get().setSemestre(cours.getSemestre());
            coursFind.get().setModule(cours.getModule());
            coursRepository.save(coursFind.get());
            return coursFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public CoursDto getCoursById(Long id) {
        Optional<Cours> cours=coursRepository.findById(id);
        if (cours.isPresent()){
            return new CoursDto(cours.get()) ;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Cours getCoursByID(Long id) {
        Optional<Cours> cours=coursRepository.findById(id);
        if (cours.isPresent()){
            return cours.get() ;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<CoursDto> listCoursProf(Long id) {
        Professeur professeur=professeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Professeur introuvable"));
        return coursRepository.findByProfesseur(professeur).stream()
                .map(cours -> new CoursDto(cours)).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<CoursDto> listCoursEtu(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant introuvable"));
        return coursRepository.findByClasse(etudiant.getClasse()).stream()
                .map(cours -> new CoursDto(cours)).collect(Collectors.toList());

    }
}
