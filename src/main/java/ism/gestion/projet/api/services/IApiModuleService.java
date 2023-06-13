package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ModuleDto;
import ism.gestion.projet.entities.Module;

import java.util.List;

public interface IApiModuleService {
    List<ModuleDto> getAllModule();
    Module addModule(Module module);
    Module updateModule(Long id,Module module);

    ModuleDto getModuleById(Long id);
    Module getModuleByID(Long id);
    void deleteModule(Long id);

}
