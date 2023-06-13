package ism.gestion.projet.services;

import ism.gestion.projet.entities.Absence;
import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.repositories.AbsenceRepository;
import ism.gestion.projet.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService implements IAbsenceService{
    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;


    @Override
    public void EtudiantAbsent(Absence absence) {
        absenceRepository.save(absence);
    }

    /**
     * @param id
     */
    @Override
    public void traiterJustification(Long id) {
        absenceRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void JustifierAbsence(Long id) {
        Optional<Absence> absence=absenceRepository.findById(id);
        if (absence.isPresent()){
            absence.get().setJustifiee(true);
            absenceRepository.save(absence.get());
        }

    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<Absence> listAbsence(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant introuvable"));
                return absenceRepository.findByEtudiant(etudiant);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int nbHeureAbsence(Long id) {
        List<Absence> absences=listAbsence(id);
        int heure=0;
        for (Absence absence:absences){
            heure+=absence.getHeure();
        }
        return heure;
    }
}
