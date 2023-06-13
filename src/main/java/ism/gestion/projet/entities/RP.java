package ism.gestion.projet.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RP")
@DiscriminatorValue(value = "ROLE_RP")
@Data
@Getter
@Setter
public class RP extends User {

}
