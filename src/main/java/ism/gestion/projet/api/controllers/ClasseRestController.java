package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.ClasseDto;
import ism.gestion.projet.api.services.IApiClasseService;
import ism.gestion.projet.entities.AnneeScolaire;
import ism.gestion.projet.entities.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/classes")
public class ClasseRestController {
    @Autowired
    IApiClasseService classeService;
    @GetMapping
    public ResponseEntity<List<ClasseDto>> getAllClasses(){
        List<ClasseDto> classes = classeService.getAllClasse();
        if (classes.isEmpty())
            throw new RuntimeException("Pas de ;module disponible");
        return ResponseEntity.ok().body(classes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClasseDto> getClassesById(@PathVariable("id") Long id){
        ClasseDto classe = classeService.getClasseById(id);
        return ResponseEntity.ok().body(classe);
    }
    @PostMapping
    public ResponseEntity<Classe> addClasse(@RequestBody Classe classe){
        Classe createdClasse=classeService.addClasse(classe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClasse);
    }

   @PutMapping("/{id}")
    public ResponseEntity<Classe> updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
        Classe optionalClasse =classeService.getClasseByID(id);
        if (optionalClasse==null) {
            return ResponseEntity.notFound().build();
        }
        //classe.setId(id);
        Classe updatedClasse = classeService.updateClasse(id,classe);
        return ResponseEntity.ok(updatedClasse);
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
    }
}
