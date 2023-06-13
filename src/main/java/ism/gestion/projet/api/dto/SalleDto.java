package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.Salle;
import ism.gestion.projet.entities.SessionCours;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalleDto {
    private Long id;
    private String nom;
    private String numero;
    private int nbPlace;

    public SalleDto(Salle salle){
        id= salle.getId();
        nom= salle.getNom();
        numero= salle.getNumero();
        nbPlace= salle.getNbPlace();
    }
}
