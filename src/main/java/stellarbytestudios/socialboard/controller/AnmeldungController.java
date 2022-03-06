package stellarbytestudios.socialboard.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stellarbytestudios.socialboard.core.UserRec;
import stellarbytestudios.socialboard.services.LoginService;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

// Dieser Controller nimmt die Anmeldedaten entgegen, validiert diese und leitet dann auf die
// anderen Controller weiter

@Controller
@RequestMapping(ANMELDUNG)
public class AnmeldungController {

    // Instanziierung
    LoginService loginService;
    // Konstruktor für automatische Injection
    public AnmeldungController(LoginService loginService) {
        this.loginService = loginService;
    }

    //Anmeldung wird momentan noch nicht verifiziert
    @GetMapping(VERIFYUSER)
    public String verify(Model m, RedirectAttributes redirectAttributes, String name, String password){

        // Waren die Eingaben überhaupt korrekt?
        // Erstmal gucken, ob überhaupt genug Eingaben da sind
        if (name == null) {
            m.addAttribute("wrongData", true);
            return "startpage";
        }
        if (password == null) {
            m.addAttribute("wrongData", true);
            return "startpage";
        }

        // Wenn alle Eingaben vorhanden sind, wird geschaut, ob dieser Nutzer in der Datenbank so gespeichert ist
        if (!loginService.validateUserLogin(name, password)){
            // Verifizierung fehlgeschlagen
            // Wird zurückgeleitet auf die Startseite
            m.addAttribute("wrongData", true);
            return "startpage";
        }
        // Sind alle Verifizierungen durchgegangen wird der Userfeed angezeigt
        // FlashAtributes sind kurzlebig und werden lokal statt über die URL übertragen
        // Schließt Sicherheitslücke (einfacher Accoundwechsel über URL)
        redirectAttributes.addFlashAttribute("username", name);

        System.out.println("User wurde verifiziert");
        return "redirect:" + USERCONTROLLER + USERFEED;


    }
}
