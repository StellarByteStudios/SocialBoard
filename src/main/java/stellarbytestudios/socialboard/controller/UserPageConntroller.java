package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stellarbytestudios.socialboard.core.UserRec;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

@Controller
@RequestMapping(USERCONTROLLER)
public class UserPageConntroller {

    @GetMapping(USERFEED)
    public String loadPersonalFeed(Model m, String username, String password){

        //Lesen aus dem Redirect
        UserRec userRec = new UserRec(0, username, password);

        m.addAttribute("userprofile", userRec);
        return "userpage";
    }
}
