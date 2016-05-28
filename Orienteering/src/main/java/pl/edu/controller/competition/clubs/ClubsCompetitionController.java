package pl.edu.controller.competition.clubs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.controller.BaseController;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsCompetitionController")
public class ClubsCompetitionController extends BaseController {

    @RequestMapping(value = {"/clubs/competition", "/clubs/competition/"})
    public String competition(){
        return "clubs/competition";
    }

}
