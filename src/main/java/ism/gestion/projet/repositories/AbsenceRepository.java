package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Absence;
import ism.gestion.projet.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    List<Absence> findByEtudiant(Etudiant etudiant);
    void deleteById(Long id);

}
