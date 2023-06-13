package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    void deleteById(Long id);
}
