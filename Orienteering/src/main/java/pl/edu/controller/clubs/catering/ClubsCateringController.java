package pl.edu.controller.clubs.catering;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.controller.BaseController;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsCateringController")
public class ClubsCateringController extends BaseController {

    @RequestMapping(value = {"/clubs/catering", "/clubs/catering/"})
    public String catering(){
        return "clubs/catering";
    }

}
