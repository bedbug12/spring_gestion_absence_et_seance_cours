package ism.gestion.projet.api.dto;

import ism.gestion.projet.entities.Etudiant;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EtudiantDto{
    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private ClasseDto classe;
    public EtudiantDto(Etudiant etudiant){
        id= etudiant.getId();
        prenom=etudiant.getPrenom();
        nom= etudiant.getNom();
        email=etudiant.getLogin();
        password=etudiant.getPassword();
        classe=new ClasseDto(etudiant.getClasse());
    }
}
