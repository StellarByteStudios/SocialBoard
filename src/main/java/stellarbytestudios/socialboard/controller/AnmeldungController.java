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

@Controller
@RequestMapping(ANMELDUNG)
public class AnmeldungController {

    // Instanziierung
    LoginService loginService;

    public AnmeldungController(LoginService loginService) {
        this.loginService = loginService;
    }

    //Anmeldung wird momentan noch nicht verifiziert
    @GetMapping(VERIFYUSER)
    public String verify(Model m, RedirectAttributes redirectAttributes, String name, String password){

        System.out.println(name + " und " + password);
        boolean verified;

        // Waren die Eingaben überhaupt korrekt?
        if (name == null) {
            verified = false;
            m.addAttribute("verified", verified);
            return "startpage";
        }
        if (password == null) {
            verified = false;
            m.addAttribute("verified", verified);
            return "startpage";
        }

        UserRec userRec = new UserRec(1, name, password);
        verified = loginService.validateUserLogin(userRec);

        if (verified){
            redirectAttributes.addAttribute("username", name);
            redirectAttributes.addAttribute("password", password);
            redirectAttributes.addAttribute("verified", verified);

            System.out.println("User wurde verifiziert");
            return "redirect:" + USERCONTROLLER + USERFEED;
        }
        // Verifizierung fehlgeschlagen
        m.addAttribute("verified", verified);
        return "startpage";

    }
}
