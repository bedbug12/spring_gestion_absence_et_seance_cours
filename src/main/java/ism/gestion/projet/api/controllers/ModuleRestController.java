package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.ModuleDto;
import ism.gestion.projet.api.services.ApiApiModuleServices;
import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Etudiant;
import ism.gestion.projet.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/modules")
public class ModuleRestController {

    @Autowired
    private ApiApiModuleServices moduleService;

    @GetMapping
    public ResponseEntity <List<ModuleDto>> getAllModule(){
        List<ModuleDto> modules = moduleService.getAllModule();
        return ResponseEntity.ok().body(modules);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> getModuleById(@PathVariable("id")Long id){
       ModuleDto modules = moduleService.getModuleById(id);
       return ResponseEntity.ok().body(modules);
    }

    @PostMapping
    public ResponseEntity<Module> addModule(@RequestBody Module module){
        Module createdModules=moduleService.addModule(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdModules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Module optionalModule =moduleService.getModuleByID(id);
        if (optionalModule==null) {
            return ResponseEntity.notFound().build();
        }
        //classe.setId(id);
        Module updatedModule = moduleService.updateModule(id,module);
        return ResponseEntity.ok(updatedModule);
    }

    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }

//    @PostMapping("/modules")
//    public Module createModule(@Valid @RequestBody Module module) {
//        return moduleService.save(module);
//    }
//
//    @PutMapping("/modules/{id}")
//    public ResponseEntity<Module> updateModule(@PathVariable(value = "id") Long moduleId,
//                                               @Valid @RequestBody Module moduleDetails) throws ResourceNotFoundException {
//        Module module = moduleService.findById(moduleId)
//                .orElseThrow(() -> new ResourceNotFoundException("Module not found for this id :: " + moduleId));
//        module.setLibelle(moduleDetails.getLibelle());
//        final Module updatedModule = moduleService.save(module);
//        return ResponseEntity.ok(updatedModule);
//    }
//
//    @DeleteMapping("/modules/{id}")
//    public Map<String, Boolean> deleteModule(@PathVariable(value = "id") Long moduleId)
//            throws ResourceNotFoundException {
//        Module module = moduleService.findById(moduleId)
//                .orElseThrow(() -> new ResourceNotFoundException("Module not found for this id :: " + moduleId));
//
//        moduleService.delete(module);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}
