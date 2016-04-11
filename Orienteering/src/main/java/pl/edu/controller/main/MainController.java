package pl.edu.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bartosz on 09.04.16.
 */

@Controller("mainController")
public class MainController {

    @RequestMapping("/")
    public String homepage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("sigh", "lesigh");
        return "index";
    }
}