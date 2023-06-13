package ism.gestion.projet.api.dto;

import ism.gestion.projet.entities.Absence;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AbsenceDto {
    private Long id;
    private Date date;
    private int heure;
    private Boolean justifiee;
    private String motifs;
    private EtudiantDto etudiant;
    private SessionCoursDto sessionCours;

    public AbsenceDto(Absence absence){
         id= absence.getId();
         date=absence.getDate();
         heure=absence.getHeure();
         justifiee=absence.getJustifiee();
         motifs=absence.getMotifs();
         etudiant=new EtudiantDto(absence.getEtudiant());
         sessionCours=new SessionCoursDto(absence.getSessionCours());
    }
}
