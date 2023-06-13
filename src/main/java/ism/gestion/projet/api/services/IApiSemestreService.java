package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.SemestreDto;
import ism.gestion.projet.entities.Semestre;

import java.util.List;

public interface IApiSemestreService {
    List<SemestreDto> getAllSemestre();
    Semestre addSemestre(Semestre semestre);
    Semestre updateSemestre(Long id,Semestre semestre);

    SemestreDto getSemestreById(Long id);
    Semestre getSemestreByID(Long id);
    void deleteSemestre(Long id);


}
