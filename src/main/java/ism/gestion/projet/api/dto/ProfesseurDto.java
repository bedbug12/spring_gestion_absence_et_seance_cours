package ism.gestion.projet.api.dto;

import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Professeur;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfesseurDto{
    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String specialite;
    private String grade;

    public ProfesseurDto(Professeur professeur){
        id= professeur.getId();
        prenom=professeur.getPrenom();
        nom= professeur.getNom();
        email=professeur.getLogin();
        password=professeur.getPassword();
        specialite=professeur.getSpecialite();
        grade=professeur.getGrade();
    }
}
