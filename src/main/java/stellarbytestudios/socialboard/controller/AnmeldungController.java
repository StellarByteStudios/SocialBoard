package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stellarbytestudios.socialboard.core.User;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

@Controller
@RequestMapping(ANMELDUNG)
public class AnmeldungController {


    //Anmeldung wird momentan noch nicht verifiziert
    @GetMapping(VERIFYUSER)
    public String verify(Model m, RedirectAttributes redirectAttributes, String name, String password){
        //Dummydaten
        User user = new User(0, "The First One", "supadupasecret");
        redirectAttributes.addAttribute("username", user.username());
        redirectAttributes.addAttribute("password", user.password());
        System.out.println("User wurde verifiziert");
        return "redirect:" + USERCONTROLLER + USERFEED;
    }
}
