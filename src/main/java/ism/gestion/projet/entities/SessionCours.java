package ism.gestion.projet.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "sessions_cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionCours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonBackReference("cours-session")
    @ManyToOne()
    @JoinColumn(name = "cours_id")
    private Cours cours;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime heureDebut;
    @Column(nullable = false)
    private LocalTime heureFin;
    @Column(nullable = false)
    private int heure;
    @JsonBackReference("salle-session")
    @ManyToOne()
    @JoinColumn(name = "salle_id")
    private Salle salle;
    @Column(nullable = false)
    private Boolean enLigne;
    @Enumerated(value = EnumType.STRING)
    private EtatSessionCours etat;
    @JsonManagedReference("session-absence")
    @OneToMany(mappedBy = "sessionCours")
    private List<Absence> absence;

}
