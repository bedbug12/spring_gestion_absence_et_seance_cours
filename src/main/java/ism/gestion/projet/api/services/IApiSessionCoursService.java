package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.SessionCoursDto;
import ism.gestion.projet.api.dto.SessionCoursDtoF;
import ism.gestion.projet.entities.SessionCours;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IApiSessionCoursService {
    List<SessionCoursDto> getAllSessioncours();
    SessionCours addSession(SessionCours sessionCours);
    SessionCours updateSession(Long id,SessionCours sessionCours);
    SessionCoursDto getSessionById(Long id);
    SessionCours getSessionByID(Long id);
    void deleteSession(Long id);
    public List<SessionCoursDto> listSessionCoursProgrammerProfesseur(Long idP);

    public List<SessionCoursDto> filtreSessionCoursPeriodeProf(Long id, LocalDate dateDebut, LocalDate dateFin);
    public List<SessionCoursDto> filtreSessionCoursModuleProf(Long idM,Long idP,LocalDate dateDebut, LocalDate dateFin);

    public List<SessionCoursDtoF> listSessionCoursProgrammerEtudiant(Long idE);
}
