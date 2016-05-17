package pl.edu.controller.admin.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.competitor.Competitors;
import pl.edu.repository.user.Users;
import pl.edu.service.competitor.ICompetitorService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminHomeController")
public class AdminHomeController {

    @Autowired
    private ICompetitorService competitorService;

    @ModelAttribute("competitorForm")
    public CompetitorForm form() {
        return new CompetitorForm();
    }

    @ModelAttribute("competitors")
    public List<Competitor> competitorList() {
        return competitorService.list(Competitors.findAll());
    }

    @RequestMapping(value = {"/admin", "/admin/"})
    public String home(){
        return "admin/index";
    }

//    @RequestMapping(value = {"/admin/deleteuser/", "/admin/deleteuser"}, method = RequestMethod.POST)
//    public String deleteUser(CompetitorForm form){
//        Competitor competitor = form.getCompetitor();
//        if(competitor != null){
//            System.out.println(competitor.getName());
//        }
//        else{
//            System.out.println("null");
//        }
//        return "admin/index";
//    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=edit")
    public String edit(CompetitorForm form) {
        System.out.println("Edit button clicked");
        Competitor competitor = form.getCompetitor();
        if(competitor != null){
            System.out.println(competitor.getName());
        }
        return "admin/index";
    }


    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=delete")
    public String delete(CompetitorForm form) {
        System.out.println("Delete button clicked");
        Competitor competitor = form.getCompetitor();
        if(competitor != null){
            System.out.println(competitor.getName());
        }
        return "admin/index";
    }
}
