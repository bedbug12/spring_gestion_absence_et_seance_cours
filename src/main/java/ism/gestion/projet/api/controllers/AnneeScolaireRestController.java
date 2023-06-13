package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.AnneeScolaireDto;
import ism.gestion.projet.api.dto.ClasseDto;
import ism.gestion.projet.api.services.IApiAnneeScolaireService;
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
@RequestMapping("/api/annees-scolaires")
public class AnneeScolaireRestController {
    @Autowired
    IApiAnneeScolaireService scolaireService;
    @GetMapping
    public ResponseEntity<List<AnneeScolaireDto>> getAllAnneeScolaires(){
        List<AnneeScolaireDto> annee = scolaireService.getAllAnneeScolaire();
        return ResponseEntity.ok().body(annee);
    }
    @PostMapping
    public ResponseEntity<AnneeScolaire> addAnneeScolaires(@RequestBody AnneeScolaire annee){
        AnneeScolaire createdAnnee=scolaireService.addAnneeScolaire(annee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnnee);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnneeScolaireDto> getAnneeById(@PathVariable("id") Long id) {
        AnneeScolaireDto annee = scolaireService.getAnneeScolaireById(id);
        return ResponseEntity.ok().body(annee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnneeScolaire> updateAnneeScolaire(@PathVariable Long id, @RequestBody AnneeScolaire anneeScolaireDetails) {
        AnneeScolaire optionalAnneeScolaire =scolaireService.getAnneeScolaireByID(id);
        if (optionalAnneeScolaire==null) {
            return ResponseEntity.notFound().build();
        }
        AnneeScolaire updatedAnneeScolaire = scolaireService.updateAnneeScolaire(id,anneeScolaireDetails);
        return ResponseEntity.ok(updatedAnneeScolaire);
    }

   @DeleteMapping("/{id}")
    public void deleteAnneeScolaire(@PathVariable Long id) {
        scolaireService.deleteAnneeScolaire(id);
    }
}
