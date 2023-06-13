package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.AnneeScolaire;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire,Long> {
    void deleteById(Long id);
}
