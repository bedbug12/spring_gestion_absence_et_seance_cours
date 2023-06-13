package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    void deleteById(Long id);
}
