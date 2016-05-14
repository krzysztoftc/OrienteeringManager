package pl.edu.controller.clubs.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsHomeController")
public class ClubsHomeController {

    @RequestMapping(value = {"/clubs", "/clubs/"})
    public String home(){
        return "clubs/index";
    }

}
