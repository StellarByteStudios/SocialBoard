package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stellarbytestudios.socialboard.core.UserRec;
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

    public UserPageConntroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(USERFEED)
    public String loadPersonalFeed(Model m, String username, String password){

        // Alle Drops aus der Datenbank holen
        List<DropRec> drops = userService.getAllDropsSortByDate();

        // Die Drops dann dem Model hinzufügen
        m.addAttribute("drops", drops);
        return "userpage";
    }

    @PostMapping(NEWDROP + "/{username}")
    public String userDropsSomething(@PathVariable String username, String dropcontent, RedirectAttributes readds){

        // Neuen Drop abspeichern
        userService.saveNewDrop(username, dropcontent);

        // Redirecten
        readds.addAttribute("username", username);
        return "redirect:" + USERCONTROLLER + USERFEED;
    }
}
