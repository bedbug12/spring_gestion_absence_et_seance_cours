package ism.gestion.projet;

import ism.gestion.projet.entities.*;
import ism.gestion.projet.entities.Module;
import ism.gestion.projet.repositories.*;
import org.aspectj.weaver.ClassAnnotationValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {
	@Autowired
	AnneeScolaireRepository anneeScolaireRepository;
	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private SalleRepository salleRepository;

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private SemestreRepository semestreRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private SessionCoursRepository sessionCoursRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		List<Classe>classes=new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			AnneeScolaire annee=new AnneeScolaire();
			annee.setAnneeScolaire("202"+i+"-202"+(i+1));
			anneeScolaireRepository.save(annee);

			Classe classe = new Classe();
			classe.setLibelle("Libelle "+i);
			classe.setFiliere("Filiere "+i);
			classe.setNiveau("L"+i);
			classe.setAnneeScolaire(annee);
			classes.add(classe);
			classeRepository.save(classe);

			Etudiant etudiant = new Etudiant();
			etudiant.setNom("Nom etu"+i);
			etudiant.setPrenom("Prenom etu"+i);
			etudiant.setClasse(classe);
			etudiant.setLogin("etudiant"+i);
			etudiant.setPassword("password");
			etudiantRepository.save(etudiant);


		}
		List<Cours> coursList=new ArrayList<>();
		for(int i=1; i<=5; i++) {
			Professeur professeur = new Professeur();
			professeur.setNom("nom prof "+i);
			professeur.setPrenom("Prenom prof "+i);
			professeur.setSpecialite("Specialite "+i);
			professeur.setLogin("prof"+i);
			professeur.setPassword("password");
			professeur.setGrade("Grade "+i);
			professeurRepository.save(professeur);

			Module module = new Module();
			module.setLibelle("module "+i);
			moduleRepository.save(module);

			Semestre semestre=new Semestre();
			semestre.setLibelle("semestre "+i);
			semestreRepository.save(semestre);

			for (Classe classe:classes) {
				Cours cours=new Cours();
				cours.setModule(module);
				cours.setProfesseur(professeur);
				cours.setSemestre(semestre);
				cours.setEcoule(0);
				cours.setHeure(20);
				cours.setClasse(classe);
				coursRepository.save(cours);
				coursList.add(cours);
			}


			Salle salle = new Salle();
			salle.setNom("salle "+i);
			salle.setNumero("Numero "+i);
			salle.setNbPlace(i*10);
			salleRepository.save(salle);


			for (Cours cours:coursList) {

			SessionCours sessionCours=new SessionCours();
			if (i%2==0){
				sessionCours.setEnLigne(true);
			}else{
				sessionCours.setSalle(salle);
				sessionCours.setEnLigne(false);
			}
			sessionCours.setCours(cours);
			sessionCours.setHeure(4);
			sessionCours.setEtat(EtatSessionCours.ENCOURS);
			sessionCours.setDate(LocalDate.of(2023,LocalDate.now().getMonthValue(),i));
			sessionCours.setHeureDebut(LocalTime.of(8,0));
			sessionCours.setHeureFin(LocalTime.of(12,0));
			sessionCoursRepository.save(sessionCours);
			}

		}

	}

}
