package pl.edu.controller.admin.accommodation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.controller.BaseController;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminAccommodationController")
public class AdminAccommodationController extends BaseController{

    @RequestMapping(value = {"/admin/accommodation", "/admin/accommodation/"})
    public String accomodation(){
        return "admin/accommodation";
    }

}
