package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.ProfesseurDto;
import ism.gestion.projet.api.dto.SessionCoursDto;
import ism.gestion.projet.api.services.IApiProfesseurService;
import ism.gestion.projet.api.services.IApiSessionCoursService;
import ism.gestion.projet.entities.Module;
import ism.gestion.projet.entities.Professeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurRestController {
    @Autowired
    IApiProfesseurService professeurService;
    @Autowired
    IApiSessionCoursService sessionCoursService;

    @GetMapping
    public ResponseEntity<List<ProfesseurDto>> getAllProfesseur(){
        List<ProfesseurDto> professeurs = professeurService.getAllProfesseur();
        return ResponseEntity.ok().body(professeurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity <ProfesseurDto> getProfesseurById(@PathVariable("id")Long id){
        ProfesseurDto professeurs = professeurService.getProfesseurById(id);
        return ResponseEntity.ok().body(professeurs);
    }
    @PostMapping
    public ResponseEntity<Professeur> addProfesseur(@RequestBody Professeur professeur){
        Professeur createdProfesseur=professeurService.AddProfesseur(professeur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfesseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeur) {
        Professeur optionalProfesseur = professeurService.getProfesseurByID(id);
        if (optionalProfesseur==null) {
            return ResponseEntity.notFound().build();
        }
        Professeur updatedProfesseur = professeurService.updateProfesseur(id,professeur);
        return ResponseEntity.ok(updatedProfesseur);
    }


    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
    }

}
