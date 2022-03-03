package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

// Dieser Controller Zeigt einfach nur die Startseite an und formatiert diese ein wenig

@Controller
public class StartPageController {

@GetMapping(STARTPAGE)
    public String getStartPage(Model m){
        // Regeln des Registrierungsfensters
        m.addAttribute("firstVisit", true);
        return "startpage";
    }
}
