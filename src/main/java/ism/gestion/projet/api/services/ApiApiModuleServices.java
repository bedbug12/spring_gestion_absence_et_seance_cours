package ism.gestion.projet.api.services;

import ism.gestion.projet.api.dto.ModuleDto;
import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.entities.Module;
import ism.gestion.projet.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ApiApiModuleServices implements IApiModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    /**
     * @return
     */
    @Override
    public List<ModuleDto> getAllModule() {
        return moduleRepository.findAll()
                .stream()
                .map(module -> new ModuleDto(module))
                .collect(Collectors.toList());
    }

    /**
     * @param module
     */
    @Override
    public Module addModule(Module module) {
        return moduleRepository.save(module);
    }

    /**
     * @param id
     * @param module
     * @return
     */
    @Override
    public Module updateModule(Long id, Module module) {
        Optional<Module> modFind=moduleRepository.findById(id);
        if (modFind.isPresent()){
            modFind.get().setLibelle(module.getLibelle());
            moduleRepository.save(modFind.get());
            return modFind.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ModuleDto getModuleById(Long id) {
         Optional<Module> module = moduleRepository.findById(id);
        if (module.isPresent()){
            return new ModuleDto(module.get());
        }
      return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Module getModuleByID(Long id) {
        Optional<Module> module = moduleRepository.findById(id);
        if (module.isPresent()){
            return module.get();
        }
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
