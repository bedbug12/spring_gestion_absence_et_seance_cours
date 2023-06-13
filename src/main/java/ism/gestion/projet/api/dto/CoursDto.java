package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.*;
import ism.gestion.projet.entities.Module;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoursDto {

    private Long id;
    private ModuleDto module;
    private ClasseDto classe;
    private SemestreDto semestre;
    private int heure;
    private int ecoule;
    public CoursDto(Cours cours){
        id= cours.getId();
        module=new ModuleDto(cours.getModule());
        classe=new ClasseDto(cours.getClasse());
        semestre=new SemestreDto(cours.getSemestre());
        heure=cours.getHeure();
        ecoule=cours.getEcoule();


    }

}
