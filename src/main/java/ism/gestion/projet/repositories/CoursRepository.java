package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Classe;
import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    List<Cours> findByProfesseur(Professeur professeur);
    List<Cours> findByClasse(Classe classe);
    void deleteById(Long id);
}
