package pl.edu.controller.clubs.accommodation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsAccommodationController")
public class ClubsAccommodationController {

    @RequestMapping(value = {"/clubs/accommodation", "/clubs/accommodation/"})
    public String accommodation(){
        return "clubs/accommodation";
    }

}
