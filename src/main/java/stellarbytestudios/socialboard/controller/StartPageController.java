package stellarbytestudios.socialboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static stellarbytestudios.socialboard.controller.PathLibary.*;

@Controller
public class StartPageController {

@GetMapping(STARTPAGE)
    public String getStartPage(Model m){
        return "startpage";
    }
}
