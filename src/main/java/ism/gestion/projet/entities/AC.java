package ism.gestion.projet.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "AC")
@DiscriminatorValue(value = "ROLE_AC")
@Data
@Getter
@Setter
public class AC extends User {
}
