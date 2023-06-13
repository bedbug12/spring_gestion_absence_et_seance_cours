package ism.gestion.projet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "etudiants")
@DiscriminatorValue(value = "ROLE_ETUDIANT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Etudiant extends User {
    @JsonBackReference("classe-etudiant")
    @ManyToOne()
    @JoinColumn(name = "classe_id")
    private Classe classe;
    @JsonManagedReference("etudiant-absence")
    @OneToMany(mappedBy = "etudiant")
    private List<Absence> absences;

}
