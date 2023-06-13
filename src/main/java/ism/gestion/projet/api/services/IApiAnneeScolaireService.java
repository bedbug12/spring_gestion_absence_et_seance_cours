package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.AnneeScolaireDto;
import ism.gestion.projet.entities.AnneeScolaire;

import java.util.List;

public interface IApiAnneeScolaireService {
    List<AnneeScolaireDto> getAllAnneeScolaire();
    AnneeScolaire addAnneeScolaire(AnneeScolaire annee);
    AnneeScolaire updateAnneeScolaire(Long id,AnneeScolaire annee);

    AnneeScolaireDto getAnneeScolaireById(Long id);
    AnneeScolaire getAnneeScolaireByID(Long id);
    void deleteAnneeScolaire(Long id);




}
