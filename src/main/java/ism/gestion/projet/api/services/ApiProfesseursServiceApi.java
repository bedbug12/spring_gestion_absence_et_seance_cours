package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ProfesseurDto;
import ism.gestion.projet.api.dto.SessionCoursDto;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.entities.SessionCours;
import ism.gestion.projet.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiProfesseursServiceApi implements IApiProfesseurService {
    @Autowired
    ProfesseurRepository professeurRepository;
    /**
     * @return
     */
    @Override
    public List<ProfesseurDto> getAllProfesseur() {
        return professeurRepository.findAll().stream()
                .map(professeur -> new ProfesseurDto(professeur)).collect(Collectors.toList());
    }

    /**
     * @param professeur
     * @return
     */
    @Override
    public Professeur AddProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    /**
     * @param id
     * @param professeur
     * @return
     */
    @Override
    public Professeur updateProfesseur(Long id, Professeur professeur) {
        Optional<Professeur> profFind=professeurRepository.findById(id);
        if (profFind.isPresent()){
            profFind.get().setNom(professeur.getNom());
            profFind.get().setPrenom(professeur.getPrenom());
            profFind.get().setLogin(professeur.getLogin());
            profFind.get().setPassword(professeur.getPassword());
            profFind.get().setSpecialite(professeur.getPrenom());
            profFind.get().setGrade(professeur.getGrade());
            professeurRepository.save(profFind.get());
            return profFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ProfesseurDto getProfesseurById(Long id) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        if (professeur.isPresent()){
            return new ProfesseurDto(professeur.get());
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Professeur getProfesseurByID(Long id) {
        Optional<Professeur> professeur = professeurRepository.findById(id);
        if (professeur.isPresent()){
            return professeur.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteProfesseur(Long id) {
       professeurRepository.deleteById(id);
    }
}
