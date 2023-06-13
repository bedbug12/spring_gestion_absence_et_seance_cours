package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.Absence;
import ism.gestion.projet.entities.EtatSessionCours;
import ism.gestion.projet.entities.SessionCours;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionCoursDto {
    private Long id;
    private LocalDate date;
    private CoursDto cours;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private SalleDto salle;
    private Boolean isOnLine;
    private EtatSessionCours etat;
    public SessionCoursDto(SessionCours sessionCours){
        id=sessionCours.getId();
        date=sessionCours.getDate();
        cours=new CoursDto(sessionCours.getCours());
        heureDebut=sessionCours.getHeureDebut();
        heureFin=sessionCours.getHeureFin();
        salle=sessionCours.getSalle()!=null?new SalleDto(sessionCours.getSalle()):null;
        isOnLine=sessionCours.getEnLigne();
        etat=sessionCours.getEtat();

    }

}
