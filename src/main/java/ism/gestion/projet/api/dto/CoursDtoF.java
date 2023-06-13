package ism.gestion.projet.api.dto;

import ism.gestion.projet.entities.Cours;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoursDtoF {

    private Long id;
    private ModuleDto module;
    private ClasseDto classe;
    private SemestreDto semestre;
    private ProfesseurDtoF professeur;
    private int heure;
    private int ecoule;
    public CoursDtoF(Cours cours){
        id= cours.getId();
        classe=new ClasseDto(cours.getClasse());
        semestre=new SemestreDto(cours.getSemestre());
        professeur=new ProfesseurDtoF(cours.getProfesseur());
        module=new ModuleDto(cours.getModule());
        heure=cours.getHeure();
        ecoule=cours.getEcoule();


    }

}
