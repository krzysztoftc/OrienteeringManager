package pl.edu.controller.user.clubs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.controller.BaseController;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsUserController")
public class ClubsUserController extends BaseController {

    @RequestMapping(value = {"/clubs/user", "/clubs/user/"})
    public String user(){
        return "clubs/user";
    }

}
