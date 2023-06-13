package ism.gestion.projet.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private String filiere;
    @Column(nullable = false)
    private String niveau;
    @JsonBackReference("annee-classe")
    @ManyToOne()
    @JoinColumn(name = "annee_scolaire_id")
    private AnneeScolaire anneeScolaire;
    @JsonManagedReference("classe-cours")
    @OneToMany(mappedBy = "classe")
    private List<Cours> cours;
    @JsonManagedReference("classe-etudiant")
    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

}
