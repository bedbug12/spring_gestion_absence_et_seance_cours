package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.SemestreDto;
import ism.gestion.projet.api.dto.SessionCoursDto;
import ism.gestion.projet.api.dto.SessionCoursDtoF;
import ism.gestion.projet.entities.Semestre;
import ism.gestion.projet.entities.SessionCours;
import ism.gestion.projet.repositories.SessionCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiSessionCoursService implements IApiSessionCoursService {
    @Autowired
    SessionCoursRepository sessionCoursRepository;
    /**
     * @return
     */
    @Override
    public List<SessionCoursDto> getAllSessioncours() {
        return sessionCoursRepository.findAll().stream()
                .map(sessionCours -> new SessionCoursDto(sessionCours)).collect(Collectors.toList());
    }

    /**
     * @param sessionCours
     * @return
     */
    @Override
    public SessionCours addSession(SessionCours sessionCours) {
        return sessionCoursRepository.save(sessionCours);
    }

    /**
     * @param id
     * @param sessionCours
     * @return
     */
    @Override
    public SessionCours updateSession(Long id, SessionCours sessionCours) {
        Optional<SessionCours> sessFind=sessionCoursRepository.findById(id);
        if (sessFind.isPresent()){
            sessFind.get().setHeure(sessionCours.getHeure());
            sessFind.get().setSalle(sessionCours.getSalle());
            sessFind.get().setCours(sessionCours.getCours());
            sessFind.get().setHeureDebut(sessionCours.getHeureDebut());
            sessFind.get().setHeureFin(sessionCours.getHeureFin());
            sessFind.get().setDate(sessionCours.getDate());
            sessFind.get().setEnLigne(sessionCours.getEnLigne());
            sessionCoursRepository.save(sessFind.get());
            return sessFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SessionCoursDto getSessionById(Long id) {
        Optional<SessionCours> session = sessionCoursRepository.findById(id);
        if (session.isPresent()){
            return new SessionCoursDto(session.get());
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public SessionCours getSessionByID(Long id) {
        Optional<SessionCours> session = sessionCoursRepository.findById(id);
        if (session.isPresent()){
            return session.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteSession(Long id) {
       sessionCoursRepository.deleteById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionCoursDto> listSessionCoursProgrammerProfesseur(Long id) {
        List<SessionCours> sessionCours = sessionCoursRepository.findAll().stream().filter(cours -> cours.getCours().getProfesseur().getId()==id).toList();
        return sessionCours.stream()
                .map(sessionCour -> new SessionCoursDto(sessionCour)).collect(Collectors.toList());
    }

    /**
     * @param id
     * @param dateDebut
     * @param dateFin
     * @return
     */
    @Override
    public List<SessionCoursDto> filtreSessionCoursPeriodeProf(Long id, LocalDate dateDebut, LocalDate dateFin) {
        List<SessionCours> sessionCours= sessionCoursRepository.findByDateBetween(LocalDate.of(dateDebut.getYear(), dateDebut.getMonth(), dateDebut.getDayOfMonth()),
                LocalDate.of(dateFin.getYear(), dateFin.getMonth(), dateFin.getDayOfMonth()));
        return sessionCours.stream().filter(cours ->cours.getCours().getProfesseur().getId()==id).toList().stream()
                .map(sessionCour -> new SessionCoursDto(sessionCour)).collect(Collectors.toList());

    }


    /**
     * @param idM
     * @return
     */
    @Override
    public List<SessionCoursDto> filtreSessionCoursModuleProf(Long idM,Long idP, LocalDate dateDebut, LocalDate dateFin) {
        List<SessionCoursDto> sessionCours= filtreSessionCoursPeriodeProf(idP,dateDebut,dateFin);
        return sessionCours.stream().filter(cours ->cours.getCours().getModule().getId()==idM).toList();
    }

    @Override
    public List<SessionCoursDtoF> listSessionCoursProgrammerEtudiant(Long id) {
        List<SessionCours> sessionCours= sessionCoursRepository.findAll();
        return sessionCours.stream().filter(cours ->cours.getCours()
                .getClasse()
                .getEtudiants()
                .listIterator()
                .next()
                .getId()==id)
                .toList()
                .stream()
                .map(sessionCours1 -> new SessionCoursDtoF(sessionCours1))
                .collect(Collectors.toList());

    }
}
