package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.SalleDto;
import ism.gestion.projet.entities.Salle;

import java.util.List;

public interface IApiSalleService {
    List<SalleDto> getAllSalle();
    Salle addSalle(Salle salle);
    Salle updateSalle(Long id,Salle salle);

    SalleDto getSalleById(Long id);
    Salle getSalleByID(Long id);
    void deleteSalle(Long id);


}
