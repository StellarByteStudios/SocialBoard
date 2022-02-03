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
@RequestMapping(USERCONTROLLER)
public class UserPageConntroller {

    @GetMapping(USERFEED)
    public String loadPersonalFeed(Model m, String username, String password){

        //Lesen aus dem Redirect
        User user = new User(0, username, password);

        m.addAttribute("userprofile", user);
        return "userpage";
    }
}
