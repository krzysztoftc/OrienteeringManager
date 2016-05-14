package pl.edu.controller.admin.accommodation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminAccommodationController")
public class AdminAccommodationController {

    @RequestMapping(value = {"/admin/accommodation", "/admin/accommodation/"})
    public String accomodation(){
        return "admin/accommodation";
    }

}
