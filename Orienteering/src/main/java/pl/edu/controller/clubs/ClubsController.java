package pl.edu.controller.clubs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsController")
public class ClubsController {

    @RequestMapping(value = {"/clubs", "/clubs/"})
    public String clubs(){
        return "clubs/index";
    }

}
