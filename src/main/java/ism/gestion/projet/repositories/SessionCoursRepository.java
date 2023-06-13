package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SessionCoursRepository extends JpaRepository<SessionCours,Long> {
    List<SessionCours> findByDateBetween(LocalDate dateDebut,LocalDate dateFin);
    void deleteById(Long id);

}
