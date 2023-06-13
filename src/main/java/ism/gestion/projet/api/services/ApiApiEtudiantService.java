package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.CoursDto;
import ism.gestion.projet.api.dto.EtudiantDto;
import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiEtudiantService implements IApiEtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    /**
     * @return
     */
    @Override
    public List<EtudiantDto> getAllEtudiant() {
        return etudiantRepository.findAll().stream()
                .map(etudiant -> new EtudiantDto(etudiant)).collect(Collectors.toList());
    }

    /**
     * @param etudiant
     * @return
     */
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    /**
     * @param id
     * @param etudiant
     * @return
     */
    @Override
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        Optional<Etudiant> etuFind=etudiantRepository.findById(id);
        if (etuFind.isPresent()){
            etuFind.get().setPrenom(etudiant.getPrenom());
            etuFind.get().setNom(etudiant.getNom());
            etuFind.get().setLogin(etudiant.getLogin());
            etuFind.get().setPassword(etudiant.getPassword());
            etuFind.get().setClasse(etudiant.getClasse());
            etudiantRepository.save(etuFind.get());
            return etuFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public EtudiantDto getEtudiantById(Long id) {
        Optional<Etudiant> etudiant=etudiantRepository.findById(id);
        if (etudiant.isPresent()){
            return new EtudiantDto(etudiant.get()) ;
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Etudiant getEtudiantByID(Long id) {
        Optional<Etudiant> etudiant=etudiantRepository.findById(id);
        if (etudiant.isPresent()){
            return etudiant.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteEtudiant(Long id) {
       etudiantRepository.deleteById(id);
    }
}
