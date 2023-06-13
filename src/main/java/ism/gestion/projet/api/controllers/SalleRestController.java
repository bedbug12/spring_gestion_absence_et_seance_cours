package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.SalleDto;
import ism.gestion.projet.api.services.IApiSalleService;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/salles")
public class SalleRestController {
    @Autowired
    IApiSalleService salleService;
    @GetMapping
    public ResponseEntity<List<SalleDto>> getAllSalles(){
        List<SalleDto> salles = salleService.getAllSalle();
        return ResponseEntity.ok().body(salles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalleDto> getSalleById(@PathVariable("id") Long id){
        SalleDto salles = salleService.getSalleById(id);
        return ResponseEntity.ok().body(salles);
    }
    @PostMapping
    public ResponseEntity<Salle> addSalle(@RequestBody Salle salle){
        Salle createdSalle=salleService.addSalle(salle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
        Salle optionalSalle = salleService.getSalleByID(id);
        if (optionalSalle==null) {
            return ResponseEntity.notFound().build();
        }
        Salle updatedSalle = salleService.updateSalle(id,salle);
        return ResponseEntity.ok(updatedSalle);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
    }
}
