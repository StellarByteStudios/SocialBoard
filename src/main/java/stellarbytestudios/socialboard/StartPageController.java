package stellarbytestudios.socialboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping("/")
    public String getStartPage(Model m){
        return "startpage";
    }
}
