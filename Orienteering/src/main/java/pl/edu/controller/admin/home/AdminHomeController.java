package pl.edu.controller.admin.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminHomeController")
public class AdminHomeController {

    @RequestMapping(value = {"/admin", "/admin/"})
    public String home(){
        return "admin/index";
    }

}
