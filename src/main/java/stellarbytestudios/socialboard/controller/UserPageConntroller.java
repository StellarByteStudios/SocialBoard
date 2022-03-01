package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stellarbytestudios.socialboard.core.DropRec;
import stellarbytestudios.socialboard.services.UserService;

import java.util.List;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

@Controller
@RequestMapping(USERCONTROLLER)
public class UserPageConntroller {

    // Instanziierung
    UserService userService;
    // Konstruktor für automatische Injection
    public UserPageConntroller(UserService userService) {
        this.userService = userService;
    }

    // Nimmt den Nutzer an und zeigt seinen Feed an (momentan noch der Globalfeed)
    @GetMapping(USERFEED)
    public String loadPersonalFeed(Model m, @ModelAttribute("username") String username){

        // Lesen aus dem Redirect und setze in das Model ein
        m.addAttribute("username", username);

        // Alle Drops aus der Datenbank holen
        List<DropRec> drops = userService.getAllDropsSortByDate();

        // Die Drops dann dem Model hinzufügen
        m.addAttribute("drops", drops);
        return "userpage";
    }

    // Der Nutzer gibt eine Nachricht ab. Diese wird dann in der Datenbank abgespeichert und der Feed wird neu geladen
    @PostMapping(NEWDROP)
    public String userDropsSomething(String username, String dropcontent, RedirectAttributes readds){

        // Neuen Drop abspeichern
        userService.saveNewDrop(username, dropcontent);

        // Redirecten
        readds.addFlashAttribute("username", username);
        return "redirect:" + USERCONTROLLER + USERFEED;
    }
}
