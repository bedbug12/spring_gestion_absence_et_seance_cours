package ism.gestion.projet.repositories;

import ism.gestion.projet.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Long> {
    void deleteById(Long id);
}
