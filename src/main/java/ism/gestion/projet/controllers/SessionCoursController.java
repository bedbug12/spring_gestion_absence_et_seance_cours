package ism.gestion.projet.controllers;

import ism.gestion.projet.entities.Cours;
import ism.gestion.projet.entities.Professeur;
import ism.gestion.projet.entities.SessionCours;
import ism.gestion.projet.services.ICoursService;
import ism.gestion.projet.services.IProfesseurService;
import ism.gestion.projet.services.ISessionCoursService;
import ism.gestion.projet.services.ProfesseursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SessionCoursController {
    @Autowired
    ISessionCoursService sessionCoursService;
    @Autowired
    IProfesseurService professeursService;
    @Autowired
    ICoursService coursService;
    @GetMapping("/ac/professeurs")
    public String allProfesseur(Model model) {
        List<Professeur> professeurs=professeursService.getAllProfesseur();
        model.addAttribute("professeurs",professeurs);
        return "professeur";
    }

    @GetMapping("/ac/session")
    public String sessionProfesseur(Model model,@RequestParam(name = "id",defaultValue = "") Long id) {
        List<SessionCours> sessionCours=sessionCoursService.listSessionCoursProgrammeMois(id, LocalDate.now().getMonthValue());
        List<Cours> cours=coursService.listCoursProf(id);
        model.addAttribute("sessions",sessionCours);
        model.addAttribute("cours",cours);
        model.addAttribute("idP",id);
        return "session";
    }
    @GetMapping("/ac/session/valider")
    public String validerSession(@RequestParam(name = "id",defaultValue = "") Long id,
                                 @RequestParam(name = "idP",defaultValue = "") Long idP) {
        sessionCoursService.validerSessionCours(id);
        return "redirect:/ac/session?id="+idP;
    }
    @GetMapping("/ac/session/invalider")
    public String invaliderSession(@RequestParam(name = "id",defaultValue = "") Long id,
                                    @RequestParam(name = "idP",defaultValue = "") Long idP) {
        sessionCoursService.invaliderSessionCours(id);
        return "redirect:/ac/session?id="+idP;
    }
    @GetMapping("/ac/session/annuler")
    public String annulerSession(@RequestParam(name = "id",defaultValue = "") Long id,
                                 @RequestParam(name = "idP",defaultValue = "") Long idP) {
        sessionCoursService.AnnulationSessionCours(id);
        return "redirect:/ac/session?id="+idP;
    }
    @GetMapping("/ac/session/module-id")
    public String getSessionByModule(Model model,@RequestParam(name = "id",defaultValue = "") Long id,
                                 @RequestParam(name = "idP",defaultValue = "") Long idP) {
        List<SessionCours> sessionCours=sessionCoursService.filtreSessionCoursModuleAC(id,idP);
        List<Cours> cours=coursService.listCoursProf(idP);
        model.addAttribute("sessions",sessionCours);
        model.addAttribute("cours",cours);
        model.addAttribute("idP",idP);

        return "session";
    }
}
