package ism.gestion.projet.services;

import ism.gestion.projet.entities.*;
import ism.gestion.projet.repositories.ProfesseurRepository;
import ism.gestion.projet.repositories.SessionCoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class SessionsCoursService implements ISessionCoursService{
    @Autowired
    private SessionCoursRepository sessionCoursRepository;
    @Autowired
    private ProfesseurRepository professeurRepository;

    /**
     * @param id
     */
    @Override
    public void AnnulationSessionCours(Long id) {
        SessionCours sessionCours = sessionCoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session de cours introuvable"));
        sessionCours.setEtat(EtatSessionCours.ANNULEE);
        sessionCoursRepository.save(sessionCours);
    }

    /**
     * @param id
     * @param mois
     * @return
     */
    @Override
    public int nbHeureCoursMois(Long id, int mois) {
        List<SessionCours> sessionsCours=listSessionCoursProgrammeMois(id,mois);
        int heures = 0;
        for (SessionCours sessionCours : sessionsCours) {
            heures += sessionCours.getHeure();
        }
        return heures;
    }

    /**
     * @param id
     * @param mois
     * @return
     */
    @Override
    public List<SessionCours> listSessionCoursProgrammeMois(Long id, int mois) {
        List<SessionCours> sessionCours= sessionCoursRepository.findByDateBetween(LocalDate.of(LocalDate.now().getYear(), mois, 1),
                                                                LocalDate.of(LocalDate.now().getYear(), mois, Month.of(mois).maxLength()));
        return sessionCours.stream().filter(cours ->cours.getCours().getProfesseur().getId()==id).toList();

    }

    /**
     * @param id
     * @param dateDebut
     * @param dateFin
     * @return
     */
    @Override
    public List<SessionCours> filtreSessionCoursPeriodeProf(Long id, Date dateDebut, Date dateFin) {
        List<SessionCours> sessionCours= sessionCoursRepository.findByDateBetween(LocalDate.of(dateDebut.getYear(), dateDebut.getMonth(), dateDebut.getDay()),
                                                                LocalDate.of(dateFin.getYear(), dateFin.getMonth(), dateFin.getDay()));
        return sessionCours.stream().filter(cours ->cours.getCours().getProfesseur().getId()==id).toList();

    }

    /**
     * @param id
     * @param dateDebut
     * @param dateFin
     * @return
     */
    @Override
    public List<SessionCours> filtreSessionCoursPeriodeEtu(Long id, Date dateDebut, Date dateFin) {
        List<SessionCours> sessionCours= sessionCoursRepository.
                findByDateBetween(LocalDate.of(dateDebut.getYear(), dateDebut.getMonth(), dateDebut.getDay()),
                                    LocalDate.of(dateFin.getYear(), dateFin.getMonth(), dateFin.getDay()));
        return sessionCours.stream().filter(cours ->cours.getCours().
                                                            getClasse().
                                                            getEtudiants().listIterator().next().getId()==id).toList();

    }

    /**
     * @param id
     */
    @Override
    public void validerSessionCours(Long id) {
        SessionCours sessionCours = sessionCoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session de cours introuvable"));
        sessionCours.setEtat(EtatSessionCours.TERMINE);
        sessionCoursRepository.save(sessionCours);
    }

    /**
     * @param id
     */
    @Override
    public void invaliderSessionCours(Long id) {
        SessionCours sessionCours = sessionCoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session de cours introuvable"));
        sessionCours.setEtat(EtatSessionCours.INVALIDE);
        sessionCoursRepository.save(sessionCours);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionCours> listSessionCoursProgrammerProfesseur(Long id) {
        List<SessionCours> sessionCours= sessionCoursRepository.findAll();
        return sessionCours.stream().filter(cours ->cours.getCours().getProfesseur().getId()==id).toList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionCours> listSessionCoursProgrammerEtudiant(Long id) {
        List<SessionCours> sessionCours= sessionCoursRepository.findAll();
        return sessionCours.stream().filter(cours ->cours.getCours()
                                                         .getClasse()
                                                         .getEtudiants()
                                                         .listIterator().next().getId()==id).toList();

    }

    /**
     * @param idM
     * @return
     */
    @Override
    public List<SessionCours> filtreSessionCoursModuleProf(Long idM,Long idP) {
        List<SessionCours> sessionCours= listSessionCoursProgrammerProfesseur(idP);
        return sessionCours.stream().filter(cours ->cours.getCours().getModule().getId()==idM).toList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<SessionCours> filtreSessionCoursModuleEtu(Long id) {
        List<SessionCours> sessionCours=listSessionCoursProgrammerEtudiant(id);
        return sessionCours.stream().filter(cours ->cours.getCours().getModule().getId()==id).toList();
    }

    /**
     * @param idM
     * @return
     */
    @Override
    public List<SessionCours> filtreSessionCoursModuleAC(Long idM,Long idP) {
        List<SessionCours> sessionCours= listSessionCoursProgrammeMois(idP,LocalDate.now().getMonthValue());
        return sessionCours.stream().filter(cours ->cours.getCours().getModule().getId()==idM).toList();
    }

    /**
     * @return
     */
    @Override
    public List<SessionCours> listSessionCoursProgrammer() {
        List<SessionCours> sessionCours= sessionCoursRepository.findAll();
        return sessionCours.stream().filter(sessionCours1 -> sessionCours1.getEtat()==EtatSessionCours.ENCOURS).toList();
    }
}
