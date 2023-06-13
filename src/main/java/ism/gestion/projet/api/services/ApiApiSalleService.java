package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ModuleDto;
import ism.gestion.projet.api.dto.SalleDto;
import ism.gestion.projet.entities.Module;
import ism.gestion.projet.entities.Salle;
import ism.gestion.projet.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiSalleService implements IApiSalleService {
    @Autowired
    SalleRepository salleRepository;
    /**
     * @return
     */
    @Override
    public List<SalleDto> getAllSalle() {
        return salleRepository.findAll().stream()
                .map(salle -> new SalleDto(salle)).collect(Collectors.toList());
    }

    /**
     * @param salle
     * @return
     */
    @Override
    public Salle addSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    /**
     * @param id
     * @param salle
     * @return
     */
    @Override
    public Salle updateSalle(Long id, Salle salle) {
        Optional<Salle> salleFind=salleRepository.findById(id);
        if (salleFind.isPresent()){
            salleFind.get().setNom(salle.getNom());
            salleFind.get().setNumero(salle.getNumero());
            salleFind.get().setNbPlace(salle.getNbPlace());
            salleRepository.save(salleFind.get());
            return salleFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SalleDto getSalleById(Long id) {
        Optional<Salle> salle = salleRepository.findById(id);
        if (salle.isPresent()){
            return new SalleDto(salle.get());
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Salle getSalleByID(Long id) {
        Optional<Salle> salle = salleRepository.findById(id);
        if (salle.isPresent()){
            return salle.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}
