package ism.gestion.projet.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professeurs")
@DiscriminatorValue(value = "ROLE_PROFESSEUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professeur extends User {
    @Column(nullable = false)
    private String specialite;
    @Column(nullable = false)
    private String grade;
    @JsonManagedReference("professeur-cours")
    @OneToMany(mappedBy = "professeur")
    private List<Cours> cours;
}
