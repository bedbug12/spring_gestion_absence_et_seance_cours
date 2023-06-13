package ism.gestion.projet.services;

import ism.gestion.projet.entities.*;
import ism.gestion.projet.entities.Module;

import java.util.List;

public interface IRPService {
    public void PlanifierSessionCours(SessionCours sessionCours);
    public void inscrireEtudiant(Etudiant etudiant);
    public void creerAnneeScolaire(AnneeScolaire anneeScolaire);
    public void creerClasse(Classe classe);
    public void PlanifierClassesOuverts(AnneeScolaire anneeScolaire,List<Classe> classes);
    public void ajouterProfesseur(Professeur professeur);
    public void creerSalle(Salle salle);
    public void creerSemestre(Semestre semestre);
    public void CreerModule(Module module);
    public void planifierCours(Cours cours);
    public List<Classe> listerClasses() ;
    public List<Professeur> listerProfesseurs();
    public List<Salle> listerSalles() ;
    public List<Semestre> listerSemestres() ;
    public List<Module> listerModules() ;
    public List<Etudiant> listerEtudiant();

}
