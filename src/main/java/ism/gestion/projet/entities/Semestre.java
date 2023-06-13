package ism.gestion.projet.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "semestres")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String libelle;
    @JsonManagedReference("semestre-cours")
    @OneToMany(mappedBy = "semestre")
    private List<Cours> cours;
}
