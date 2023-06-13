package ism.gestion.projet.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "salles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private int nbPlace;
    @JsonManagedReference("salle-session")
    @OneToMany(mappedBy = "salle")
    private List<SessionCours> sessionCours;
}
