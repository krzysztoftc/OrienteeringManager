package pl.edu.controller.admin.catering;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminCateringController")
public class AdminCateringController {

    @RequestMapping(value = {"/admin/catering", "/admin/catering/"})
    public String catering(){
        return "admin/catering";
    }

}
