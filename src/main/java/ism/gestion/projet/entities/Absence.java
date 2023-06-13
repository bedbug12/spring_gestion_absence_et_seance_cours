package ism.gestion.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "absences")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private int heure;
    @Column(nullable = false)
    private Boolean justifiee;
    @Column(nullable = false)
    private String motifs;
    @JsonBackReference("etudiant-absence")
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @JsonBackReference("session-absence")
    @ManyToOne
    @JoinColumn(name = "session_cours_id")
    private SessionCours sessionCours;
}
