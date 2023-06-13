package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.AnneeScolaire;
import ism.gestion.projet.entities.Classe;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnneeScolaireDto {

    private Long id;
    private String libelle;

    public AnneeScolaireDto(AnneeScolaire anneeScolaire){
        id= anneeScolaire.getId();
        libelle= anneeScolaire.getAnneeScolaire();


    }

}
