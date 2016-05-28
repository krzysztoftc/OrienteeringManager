package pl.edu.controller.admin.home.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.category.Category;
import pl.edu.model.club.Club;
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

    @ModelAttribute("clubList")
    public List<Club> clubList(){
        List<Club> clubList = clubService.list(Clubs.findAll());
        return clubList;
    }

    @ModelAttribute("categoryList")
    public List<Category> categoryList(){
        List<Category> categoryList = categoryService.list(Categories.findAll());
        return categoryList;
    }

    @RequestMapping(value = {"/admin/edit/competitor", "/admin/edit/competitor/"})
    public String home(@ModelAttribute("competitorForm") CompetitorForm form,
                       BindingResult bindingResult){
        return "admin/edit/competitor";
    }

    @RequestMapping(value = {"/admin/edit/competitor", "/admin/edit/competitor/"},
            method=RequestMethod.POST, params="action=save")
    public String saveCompetitor(@ModelAttribute("competitorForm") CompetitorForm form,
                                 BindingResult bindingResult) {
        String resultView = "redirect:/admin";
        try {
            competitorService.saveOrUpdate(form.getCompetitor());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/competitor";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/competitor", "/admin/edit/competitor/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelCompetitor() {
        return "redirect:/admin";
    }
}
