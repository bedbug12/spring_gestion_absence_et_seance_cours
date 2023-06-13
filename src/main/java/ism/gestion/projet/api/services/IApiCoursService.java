package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.CoursDto;
import ism.gestion.projet.entities.Cours;

import java.util.List;

public interface IApiCoursService {
    List<CoursDto> getAllCours();
    Cours addCours(Cours cours);
    Cours updateCours(Long id,Cours cours);

    CoursDto getCoursById(Long id);
    Cours getCoursByID(Long id);
    void deleteCours(Long id);

    public List<CoursDto> listCoursProf(Long id);
    public List<CoursDto> listCoursEtu(Long id);
}
