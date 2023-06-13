package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Salle;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle,Long> {
    void deleteById(Long id);
}
