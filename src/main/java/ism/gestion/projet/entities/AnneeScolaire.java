package ism.gestion.projet.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "annee_scolaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnneeScolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String anneeScolaire;
    @JsonManagedReference("annee-classe")
    @OneToMany(mappedBy = "anneeScolaire")
    private List<Classe>  classes;

}
