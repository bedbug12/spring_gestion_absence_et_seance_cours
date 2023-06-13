package ism.gestion.projet.services;

import ism.gestion.projet.entities.*;
import ism.gestion.projet.entities.Module;
import ism.gestion.projet.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RPService implements IRPService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private SessionCoursRepository sessionCoursRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;
    @Autowired
    private  ProfesseurRepository professeurRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private SemestreRepository semestreRepository;

    /**
     * @param sessionCours
     *  cours
     *  salle
     */
    @Override
    public void PlanifierSessionCours(SessionCours sessionCours) {
        sessionCoursRepository.save(sessionCours);

    }

    /**
     * @param etudiant
     *  classe
     */
    @Override
    public void inscrireEtudiant(Etudiant etudiant) {

        etudiantRepository.save(etudiant);
    }

    /**
     * @param anneeScolaire
     */
    @Override
    public void creerAnneeScolaire(AnneeScolaire anneeScolaire) {

        anneeScolaireRepository.save(anneeScolaire);
    }

    /**
     * @param classe
     */
    @Override
    public void creerClasse(Classe classe) {
        classeRepository.save(classe);
    }

    /**
     *  classes
     * @param anneeScolaire
     */
    @Override
    public void PlanifierClassesOuverts(AnneeScolaire anneeScolaire,List<Classe> classes) {
           Optional<AnneeScolaire>  annee=anneeScolaireRepository.findById(anneeScolaire.getId());
           if(annee.isPresent()){
               anneeScolaire.setClasses(classes);
               anneeScolaireRepository.save(anneeScolaire);
           }
    }

    /**
     * @param professeur
     */
    @Override
    public void ajouterProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    /**
     * @param salle
     */
    @Override
    public void creerSalle(Salle salle) {
        salleRepository.save(salle);
    }

    /**
     * @param semestre
     */
    @Override
    public void creerSemestre(Semestre semestre) {
        semestreRepository.save(semestre);
    }

    /**
     * @param module
     */
    @Override
    public void CreerModule(Module module) {
        moduleRepository.save(module);
    }

    /**
     * @param cours
     *  module
     *  semestre
     *  professeurs
     *  classes
     */
    @Override
    public void planifierCours(Cours cours) {
        coursRepository.save(cours);
    }

    public List<Classe> listerClasses() {
        return classeRepository.findAll();
    }

    public List<Professeur> listerProfesseurs() {
        return professeurRepository.findAll();
    }

    public List<Salle> listerSalles() {
        return salleRepository.findAll();
    }

    public List<Semestre> listerSemestres() {
        return semestreRepository.findAll();
    }

    public List<Module> listerModules() {
        return moduleRepository.findAll();
    }

    /**
     * @return
     */
    @Override
    public List<Etudiant> listerEtudiant() {
        return etudiantRepository.findAll();
    }

}
