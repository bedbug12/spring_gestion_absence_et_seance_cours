package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.RP;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPRepository extends JpaRepository<RP,Long> {

}
