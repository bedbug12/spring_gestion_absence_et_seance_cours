package ism.gestion.projet.api.dto;
import ism.gestion.projet.entities.EtatSessionCours;
import ism.gestion.projet.entities.SessionCours;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionCoursDtoF {
    private Long id;
    private LocalDate date;
    private CoursDtoF cours;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private SalleDto salle;
    private Boolean isOnLine;
    private EtatSessionCours etat;
    public SessionCoursDtoF(SessionCours sessionCours){
        id=sessionCours.getId();
        date=sessionCours.getDate();
        cours=new CoursDtoF(sessionCours.getCours());
        heureDebut=sessionCours.getHeureDebut();
        heureFin=sessionCours.getHeureFin();
        salle=sessionCours.getSalle()!=null?new SalleDto(sessionCours.getSalle()):null;
        isOnLine=sessionCours.getEnLigne();
        etat=sessionCours.getEtat();

    }

}
