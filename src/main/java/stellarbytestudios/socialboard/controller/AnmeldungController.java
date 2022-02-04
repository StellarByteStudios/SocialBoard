package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import stellarbytestudios.socialboard.core.UserRec;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

@Controller
@RequestMapping(ANMELDUNG)
public class AnmeldungController {


    //Anmeldung wird momentan noch nicht verifiziert
    @GetMapping(VERIFYUSER)
    public String verify(Model m, RedirectAttributes redirectAttributes, String name, String password){
        //Dummydaten
        UserRec userRec = new UserRec(0, "The First One", "supadupasecret");
        redirectAttributes.addAttribute("username", userRec.username());
        redirectAttributes.addAttribute("password", userRec.password());
        System.out.println("User wurde verifiziert");
        return "redirect:" + USERCONTROLLER + USERFEED;
    }
}
