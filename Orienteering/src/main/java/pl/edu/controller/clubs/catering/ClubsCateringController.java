package pl.edu.controller.clubs.catering;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsCateringController")
public class ClubsCateringController {

    @RequestMapping(value = {"/clubs/catering", "/clubs/catering/"})
    public String catering(){
        return "clubs/catering";
    }

}
