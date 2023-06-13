package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Classe;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    void deleteById(Long id);
}
