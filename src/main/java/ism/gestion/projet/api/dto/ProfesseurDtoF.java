package ism.gestion.projet.api.dto;

import ism.gestion.projet.entities.Professeur;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfesseurDtoF {
    private Long id;
    private String prenom;
    private String nom;
    private String email;

    public ProfesseurDtoF(Professeur professeur){
        id= professeur.getId();
        prenom=professeur.getPrenom();
        nom= professeur.getNom();
        email=professeur.getLogin();
    }
}
