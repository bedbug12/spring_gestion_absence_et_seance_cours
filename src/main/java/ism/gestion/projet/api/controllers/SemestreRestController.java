package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.SemestreDto;
import ism.gestion.projet.api.services.IApiSemestreService;
import ism.gestion.projet.entities.Salle;
import ism.gestion.projet.entities.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/semestres")
public class SemestreRestController {
    @Autowired
    IApiSemestreService semestreService;
    @GetMapping
    public ResponseEntity<List<SemestreDto>> getAllSemestre(){
        List<SemestreDto> semestres = semestreService.getAllSemestre();
        return ResponseEntity.ok().body(semestres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemestreDto> getSemestreById(@PathVariable("id") Long id){
        SemestreDto semestres = semestreService.getSemestreById(id);
        return ResponseEntity.ok().body(semestres);
    }
    @PostMapping
    public ResponseEntity<Semestre> addSemestre(@RequestBody Semestre semestre){
        Semestre createdSemestre=semestreService.addSemestre(semestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSemestre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semestre> updateSemestre(@PathVariable Long id, @RequestBody Semestre semestre) {
        Semestre optionalSemestre = semestreService.getSemestreByID(id);
        if (optionalSemestre==null) {
            return ResponseEntity.notFound().build();
        }
        Semestre updatedSemestre = semestreService.updateSemestre(id,semestre);
        return ResponseEntity.ok(updatedSemestre);
    }

    @DeleteMapping("/{id}")
    public void deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
    }
}
