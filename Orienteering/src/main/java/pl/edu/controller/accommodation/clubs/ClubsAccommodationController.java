package pl.edu.controller.accommodation.clubs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.controller.BaseController;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsAccommodationController")
public class ClubsAccommodationController extends BaseController {

    @RequestMapping(value = {"/clubs/accommodation", "/clubs/accommodation/"})
    public String accommodation(){
        return "clubs/accommodation";
    }

}
