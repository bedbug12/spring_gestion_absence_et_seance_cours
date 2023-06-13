package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Semestre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SemestreDto {
    private Long id;
    private String libelle;

    public SemestreDto(Semestre semestre){
        id= semestre.getId();
        libelle= semestre.getLibelle();

    }
}
