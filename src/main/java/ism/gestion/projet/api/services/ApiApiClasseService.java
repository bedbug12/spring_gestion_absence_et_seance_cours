package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ClasseDto;
import ism.gestion.projet.entities.Classe;
import ism.gestion.projet.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiClasseService implements IApiClasseService {
    @Autowired
    ClasseRepository classeRepository;
    /**
     * @return
     */
    @Override
    public List<ClasseDto> getAllClasse() {
        return classeRepository.findAll().stream()
                .map(classe -> new ClasseDto(classe)).collect(Collectors.toList());
    }

    /**
     * @param classe
     * @return
     */
    @Override
    public Classe addClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    /**
     * @param id
     * @param classe
     * @return
     */
    @Override
    public Classe updateClasse(Long id, Classe classe) {
        Optional<Classe> classeFind=classeRepository.findById(id);
        if (classeFind.isPresent()){
            classeFind.get().setNiveau(classe.getNiveau());
            classeFind.get().setFiliere(classe.getFiliere());
            classeFind.get().setLibelle(classe.getLibelle());
            classeRepository.save(classeFind.get());
            return classeFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ClasseDto getClasseById(Long id) {
        Optional<Classe> classe=classeRepository.findById(id);
        if (classe.isPresent()){
            return new ClasseDto(classe.get()) ;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Classe getClasseByID(Long id) {
        Optional<Classe> classe=classeRepository.findById(id);
        if (classe.isPresent()){
            return classe.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }
}
