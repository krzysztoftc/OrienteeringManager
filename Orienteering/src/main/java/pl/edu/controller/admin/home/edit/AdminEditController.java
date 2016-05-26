package pl.edu.controller.admin.home.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.club.Club;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.category.Categories;
import pl.edu.repository.club.Clubs;
import pl.edu.service.category.ICategoryService;
import pl.edu.service.club.IClubService;
import pl.edu.service.competitor.ICompetitorService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminEditController")
public class AdminEditController extends BaseController {

    @Autowired
    private ICompetitorService competitorService;

    @Autowired
    private IClubService clubService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("competitorForm")
    public CompetitorForm form() {
        return new CompetitorForm();
    }

    @RequestMapping(value = {"/admin/edit/competitor", "/admin/edit/competitor/"})
    public String home(Model model, @ModelAttribute("competitorForm") CompetitorForm form){
//        model.addAttribute("competitorForm", form);
        return "admin/edit/competitor";
    }

    @RequestMapping(value = {"/admin/edit/competitor", "/admin/edit/competitor/"},
            method=RequestMethod.POST, params="action=save")
    public String saveCompetitor(Model model, @ModelAttribute("competitorForm") CompetitorForm form) {
//        String clubName = form.getClubName();
//        String categoryName = form.getCategory();
//        String errorString = "";
        String resultView = "redirect:/admin";
//        try{
//            Long clubId = clubService.uniqueObject(Clubs.findAll().withClubName(clubName)).getId();
//            Long categoryId = categoryService.uniqueObject(Categories.findAll().withName(categoryName)).getId();
//
//            Competitor competitor = form.getCompetitor();
//            competitor.setClub(club);
//            competitor.setCategory(categoryId);
//
//            competitorService.saveOrUpdate(competitor);
//        }
//        catch(NullPointerException e){
//            errorString = "Nie znaleziono klubu lub kategorii";
//            resultView = "admin/edit/competitor";
//        }
//        catch(Exception e){
//            errorString = "Nieznany błąd";
//            resultView = "admin/edit/competitor";
//        }
//        finally {
//            model.addAttribute("errorString", errorString);
//        }

        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/competitor", "/admin/edit/competitor/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelCompetitor() {
        return "redirect:/admin";
    }
}
