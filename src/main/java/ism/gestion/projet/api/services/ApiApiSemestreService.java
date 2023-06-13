package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.SalleDto;
import ism.gestion.projet.api.dto.SemestreDto;
import ism.gestion.projet.entities.Salle;
import ism.gestion.projet.entities.Semestre;
import ism.gestion.projet.repositories.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiSemestreService implements IApiSemestreService {
    @Autowired
    SemestreRepository semestreRepository;
    /**
     * @return
     */
    @Override
    public List<SemestreDto> getAllSemestre() {
        return semestreRepository.findAll().stream()
                .map(semestre -> new SemestreDto(semestre)).collect(Collectors.toList());

    }

    /**
     * @param semestre
     * @return
     */
    @Override
    public Semestre addSemestre(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    /**
     * @param id
     * @param semestre
     * @return
     */
    @Override
    public Semestre updateSemestre(Long id, Semestre semestre) {
        Optional<Semestre> semFind=semestreRepository.findById(id);
        if (semFind.isPresent()){
            semFind.get().setLibelle(semestre.getLibelle());
            semestreRepository.save(semFind.get());
            return semFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SemestreDto getSemestreById(Long id) {
        Optional<Semestre> semestre = semestreRepository.findById(id);
        if (semestre.isPresent()){
            return new SemestreDto(semestre.get());
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Semestre getSemestreByID(Long id) {
        Optional<Semestre> semestre = semestreRepository.findById(id);
        if (semestre.isPresent()){
            return semestre.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteSemestre(Long id) {
       semestreRepository.deleteById(id);
    }
}
