package ism.gestion.projet.api.controllers;

import ism.gestion.projet.api.dto.SessionCoursDto;
import ism.gestion.projet.api.dto.SessionCoursDtoF;
import ism.gestion.projet.api.services.IApiSessionCoursService;
import ism.gestion.projet.entities.Semestre;
import ism.gestion.projet.entities.SessionCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/sessions-cours")
public class SessionCoursRestController {
    @Autowired
    IApiSessionCoursService sessionCoursService;
    @GetMapping
    public ResponseEntity<List<SessionCoursDto>> getAllSessionCours(){
        List<SessionCoursDto> sessionCours = sessionCoursService.getAllSessioncours();
        return ResponseEntity.ok().body(sessionCours);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionCoursDto> getSessionCoursById(@PathVariable("id")Long id){
        SessionCoursDto sessionCours = sessionCoursService.getSessionById(id);
        return ResponseEntity.ok().body(sessionCours);
    }
    @PostMapping
    public ResponseEntity<SessionCours> addSessionCours(@RequestBody SessionCours sessionCours){
        SessionCours createdSessionCours=sessionCoursService.addSession(sessionCours);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSessionCours);
    }

    @GetMapping("/professeur/{id}")
    public ResponseEntity<List<SessionCoursDto>> getSessionProfesseur(@PathVariable("id") Long id){
        List<SessionCoursDto> sessionCours = sessionCoursService.listSessionCoursProgrammerProfesseur(id);
        return ResponseEntity.ok().body(sessionCours);
    }

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<List<SessionCoursDtoF>> getSessionEtudiant(@PathVariable("id") Long id){
        List<SessionCoursDtoF> sessionCours = sessionCoursService.listSessionCoursProgrammerEtudiant(id);
        return ResponseEntity.ok().body(sessionCours);
    }

    @GetMapping("/professeur/{id}/{dateD}/{dateF}")
    public ResponseEntity<List<SessionCoursDto>> getSessionProfesseurByPeriod(@PathVariable("id") Long id,
                                                                              @PathVariable("dateD") String dateD,
                                                                              @PathVariable("dateF") String dateF){
        String[] dateDD= dateD.split("-");
        String[] dateFF= dateF.split("-");
        LocalDate debut=LocalDate.of(Integer.parseInt(dateDD[0]),Integer.parseInt(dateDD[1]),Integer.parseInt(dateDD[2]));
        LocalDate fin=LocalDate.of(Integer.parseInt(dateFF[0]),Integer.parseInt(dateFF[1]),Integer.parseInt(dateFF[2]));
        List<SessionCoursDto> sessionCours = sessionCoursService.filtreSessionCoursPeriodeProf(id,debut,fin);
        return ResponseEntity.ok().body(sessionCours);
    }

    @GetMapping("/professeur/{idP}/{idM}/{dateD}/{dateF}")
    public ResponseEntity<List<SessionCoursDto>> getSessionProfesseurByModule(@PathVariable("idP") Long idP,
                                                                              @PathVariable("idM") Long idM,
                                                                              @PathVariable("dateD") String dateD,
                                                                              @PathVariable("dateF") String dateF){
        String[] dateDD= dateD.split("-");
        String[] dateFF= dateF.split("-");
        LocalDate debut=LocalDate.of(Integer.parseInt(dateDD[0]),Integer.parseInt(dateDD[1]),Integer.parseInt(dateDD[2]));
        LocalDate fin=LocalDate.of(Integer.parseInt(dateFF[0]),Integer.parseInt(dateFF[1]),Integer.parseInt(dateFF[2]));
        List<SessionCoursDto> sessionCours = sessionCoursService.filtreSessionCoursModuleProf(idP,idM,debut,fin);
        return ResponseEntity.ok().body(sessionCours);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SessionCours> updateSession(@PathVariable Long id, @RequestBody SessionCours sessionCours) {
        SessionCours optionalSession = sessionCoursService.getSessionByID(id);
        if (optionalSession==null) {
            return ResponseEntity.notFound().build();
        }
        SessionCours updatedSession = sessionCoursService.updateSession(id,sessionCours);
        return ResponseEntity.ok(updatedSession);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionCoursService.deleteSession(id);
    }
}
