package ism.gestion.projet.api.dto;

import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Module;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {
    private Long id;
    private String libelle;

    public ModuleDto(Module module){
        id=module.getId();
        libelle= module.getLibelle();
    }
}
