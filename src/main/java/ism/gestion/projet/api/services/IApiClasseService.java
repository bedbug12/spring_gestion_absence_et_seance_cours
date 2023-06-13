package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ClasseDto;
import ism.gestion.projet.entities.Classe;

import java.util.List;

public interface IApiClasseService {
    List<ClasseDto> getAllClasse();
    Classe addClasse(Classe classe);
    Classe updateClasse(Long id,Classe classe);

    ClasseDto getClasseById(Long id);
    Classe getClasseByID(Long id);
    void deleteClasse(Long id);



}
