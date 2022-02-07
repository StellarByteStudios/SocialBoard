package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stellarbytestudios.socialboard.services.RegistationService;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

@Controller
@RequestMapping(REGISTRIERUNG)
public class RegistrierungController {

    // Instanziierung
    RegistationService loginService;

    public RegistrierungController(RegistationService loginService) {
        this.loginService = loginService;
    }


    @PostMapping(NEWUSER)
    public String registerNewUser(Model m,
                                  String nameregi,
                                  String passwordregi,
                                  String passwordwiederholung){


        System.out.println("Der Name: " + nameregi + "; das Passwort: " + passwordregi + "; die Wiederholung: " + passwordwiederholung);
        //Sind alle eingaben da?
        if (nameregi.equals("") || passwordregi.equals("") || passwordwiederholung.equals("")){
            m.addAttribute("firstVisit", false);
            m.addAttribute("noInputRegi", true);
            m.addAttribute("falsePassword", false);
            m.addAttribute("nameTaken", false);
            // Anmeldung soll nicht verändert werden (Work in Progress)
            m.addAttribute("verified", true);

            return "startpage";
        }

        // Gibt es diesen User bereits?
        if (loginService.usernameAlreadyTaken(nameregi)){
            m.addAttribute("firstVisit", false);
            m.addAttribute("noInputRegi", false);
            m.addAttribute("falsePassword", false);
            m.addAttribute("nameTaken", true);
            // Anmeldung soll nicht verändert werden (Work in Progress)
            m.addAttribute("verified", true);

            return "startpage";
        }
        // Stimmen die Passwörter überein?
        if (!passwordregi.equals(passwordwiederholung)){
            m.addAttribute("firstVisit", false);
            m.addAttribute("noInputRegi", false);
            m.addAttribute("falsePassword", true);
            m.addAttribute("nameTaken", false);
            // Anmeldung soll nicht verändert werden (Work in Progress)
            m.addAttribute("verified", true);

            return "startpage";
        }
        // Wenn wir hier sind, waren alle tests erfolgreich
        // --> müssen den neuen Nutzer jetzt auch in der Datenbank abspeichern
        loginService.createNewUser(nameregi, passwordregi);


        return "registrationSuccessfull";
    }
}
