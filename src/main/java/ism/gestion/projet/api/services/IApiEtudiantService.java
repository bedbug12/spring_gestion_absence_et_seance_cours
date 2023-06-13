package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.EtudiantDto;
import ism.gestion.projet.entities.Etudiant;

import java.util.List;

public interface IApiEtudiantService {
    List<EtudiantDto> getAllEtudiant();
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Long id,Etudiant etudiant);

    EtudiantDto getEtudiantById(Long id);
    Etudiant getEtudiantByID(Long id);
    void deleteEtudiant(Long id);


}
