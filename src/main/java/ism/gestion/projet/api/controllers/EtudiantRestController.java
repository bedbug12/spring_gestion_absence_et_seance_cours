package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.EtudiantDto;
import ism.gestion.projet.api.services.IApiEtudiantService;
import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantRestController {
    @Autowired
    IApiEtudiantService etudiantService;
    @GetMapping
    public ResponseEntity<List<EtudiantDto>> getAllAnneeScolaires(){
        List<EtudiantDto> etudiants = etudiantService.getAllEtudiant();
        return ResponseEntity.ok().body(etudiants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDto> getAnneeScolairesById(@PathVariable("id") Long id){
        EtudiantDto etudiants = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok().body(etudiants);
    }
    @PostMapping
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant){
        Etudiant createdEtudiant=etudiantService.addEtudiant(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEtudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant optionalEtudiant =etudiantService.getEtudiantByID(id);
        if (optionalEtudiant==null) {
            return ResponseEntity.notFound().build();
        }
        //classe.setId(id);
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id,etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }
}
