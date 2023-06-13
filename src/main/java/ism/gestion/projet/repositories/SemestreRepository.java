package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Semestre;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    void deleteById(Long id);
}
