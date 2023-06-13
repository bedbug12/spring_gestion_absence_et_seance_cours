package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.AC;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ACRepository extends JpaRepository<AC,Long> {
}
