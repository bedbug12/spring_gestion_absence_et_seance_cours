package ism.gestion.projet.services;

import ism.gestion.projet.entities.Absence;
import ism.gestion.projet.entities.Etudiant;

import java.util.List;

public interface IAbsenceService {
    public void EtudiantAbsent(Absence absence);
    public void traiterJustification(Long id);
    public void JustifierAbsence(Long id);
    public List<Absence> listAbsence(Long id);
    public int nbHeureAbsence(Long id);

}
