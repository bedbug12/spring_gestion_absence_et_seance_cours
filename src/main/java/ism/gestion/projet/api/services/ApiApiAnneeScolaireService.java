package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.AnneeScolaireDto;
import ism.gestion.projet.api.dto.ClasseDto;
import ism.gestion.projet.entities.AnneeScolaire;
import ism.gestion.projet.entities.Classe;
import ism.gestion.projet.repositories.AnneeScolaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApiApiAnneeScolaireService implements IApiAnneeScolaireService {
    @Autowired
    AnneeScolaireRepository anneeScolaireRepository;

    /**
     * @return
     */
    @Override
    public List<AnneeScolaireDto> getAllAnneeScolaire() {
        return anneeScolaireRepository.findAll().stream()
                .map(anneeScolaire -> new AnneeScolaireDto(anneeScolaire)).collect(Collectors.toList());
    }

    /**
     * @param annee
     * @return
     */
    @Override
    public AnneeScolaire addAnneeScolaire(AnneeScolaire annee) {
        return anneeScolaireRepository.save(annee);
    }

    /**
     * @param id
     * @param annee
     * @return
     */
    @Override
    public AnneeScolaire updateAnneeScolaire(Long id, AnneeScolaire annee) {
        Optional<AnneeScolaire> anneeFind=anneeScolaireRepository.findById(id);
        if (anneeFind.isPresent()){
            anneeFind.get().setAnneeScolaire(annee.getAnneeScolaire());
            anneeScolaireRepository.save(anneeFind.get());
            return anneeFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public AnneeScolaireDto getAnneeScolaireById(Long id) {
        Optional<AnneeScolaire> annee=anneeScolaireRepository.findById(id);
        if (annee.isPresent()){
            return new AnneeScolaireDto(annee.get()) ;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public AnneeScolaire getAnneeScolaireByID(Long id) {
        Optional<AnneeScolaire> annee=anneeScolaireRepository.findById(id);
        if (annee.isPresent()){
            return annee.get() ;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteAnneeScolaire(Long id) {
        anneeScolaireRepository.deleteById(id);
    }
}
