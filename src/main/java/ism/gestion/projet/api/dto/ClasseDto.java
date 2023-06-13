package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.Classe;
import ism.gestion.projet.entities.Cours;
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
public class ClasseDto {

    private Long id;
    private String libelle;
    private String filiere;
    private String niveau;


    public ClasseDto(Classe classe){
        id=classe.getId();
        libelle= classe.getLibelle();
        filiere= classe.getFiliere();
        niveau= classe.getNiveau();

    }

}
