package ism.gestion.projet.services;

import ism.gestion.projet.entities.*;
import ism.gestion.projet.entities.Module;

import java.sql.Date;
import java.util.List;

public interface ISessionCoursService {
    public void AnnulationSessionCours(Long id);
    public int nbHeureCoursMois(Long id,int mois);
    public List<SessionCours> listSessionCoursProgrammeMois(Long id,int mois);
    public List<SessionCours> filtreSessionCoursPeriodeProf(Long id,Date dateDebut,Date dateFin);
    public List<SessionCours> filtreSessionCoursPeriodeEtu(Long id,Date dateDebut,Date dateFin);

    public void validerSessionCours(Long id);
    public void invaliderSessionCours(Long id);
    public List<SessionCours> listSessionCoursProgrammerProfesseur(Long idP);
    public List<SessionCours> listSessionCoursProgrammerEtudiant(Long idE);

    public List<SessionCours> filtreSessionCoursModuleProf(Long idM,Long idP);
    public List<SessionCours> filtreSessionCoursModuleEtu(Long id);
    public List<SessionCours> filtreSessionCoursModuleAC(Long id,Long idP);
    public List<SessionCours> listSessionCoursProgrammer();

}
