package ism.gestion.projet.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cours")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private int heure;
    @Column(nullable = false)
    private int ecoule;
    @JsonBackReference("module-cours")
    @ManyToOne()
    @JoinColumn(name = "module_id")
    private Module module;
    @JsonBackReference("semestre-cours")
    @ManyToOne()
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;
    @JsonBackReference("classe-cours")
    @ManyToOne()
    @JoinColumn(name = "classe_id")
    private Classe classe;
    @JsonBackReference("professeur-cours")
    @ManyToOne()
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;
    @JsonManagedReference("cours-session")
    @OneToMany(mappedBy = "cours")
    private List<SessionCours> sessionCours;
}
