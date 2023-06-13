package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ProfesseurDto;
import ism.gestion.projet.entities.Professeur;

import java.util.List;

public interface IApiProfesseurService {
    List<ProfesseurDto> getAllProfesseur();
    Professeur AddProfesseur(Professeur professeur);
    Professeur updateProfesseur(Long id,Professeur professeur);

    ProfesseurDto getProfesseurById(Long id);
    Professeur getProfesseurByID(Long id);
    void deleteProfesseur(Long id);



}
