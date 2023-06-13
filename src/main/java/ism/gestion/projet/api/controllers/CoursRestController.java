package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.CoursDto;
import ism.gestion.projet.api.services.IApiCoursService;
import ism.gestion.projet.entities.Classe;
import ism.gestion.projet.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/cours")
public class CoursRestController {
    @Autowired
    IApiCoursService coursService;
    @GetMapping
    public ResponseEntity<List<CoursDto>> getAllCours(){
        List<CoursDto> cours = coursService.getAllCours();
        return ResponseEntity.ok().body(cours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDto> getCoursById(@PathVariable("id") Long id){
        CoursDto cours = coursService.getCoursById(id);
        return ResponseEntity.ok().body(cours);
    }
    @PostMapping
    public ResponseEntity<Cours> addCours(@RequestBody Cours cours){
        Cours createdCours=coursService.addCours(cours);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCours);
    }
    @GetMapping("/professeur/{id}")
    public ResponseEntity<List<CoursDto>> getProfCours(@PathVariable("id") Long id){
        List<CoursDto> cours = coursService.listCoursProf(id);
        return ResponseEntity.ok().body(cours);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cours> updateCours(@PathVariable Long id, @RequestBody Cours cours) {
        Cours optionalCours =coursService.getCoursByID(id);
        if (optionalCours==null) {
            return ResponseEntity.notFound().build();
        }
        //classe.setId(id);
        Cours updatedCours = coursService.updateCours(id,cours);
        return ResponseEntity.ok(updatedCours);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }
}
