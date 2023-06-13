package ism.gestion.projet.services;

import ism.gestion.projet.api.dto.ProfesseurDto;
import ism.gestion.projet.entities.Professeur;

import java.util.List;

public interface IProfesseurService {
    List<Professeur> getAllProfesseur();
    Professeur AddProfesseur(Professeur professeur);
}
