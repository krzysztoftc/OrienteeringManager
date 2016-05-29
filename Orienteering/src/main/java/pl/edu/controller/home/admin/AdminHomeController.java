package pl.edu.controller.home.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pl.edu.controller.BaseController;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.controller.competitor.form.CompetitorOptionsList;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.category.Category;
import pl.edu.model.catering.Catering;
import pl.edu.model.competition.CompetitonInfo;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.accommodation.Accommodations;
import pl.edu.repository.category.Categories;
import pl.edu.repository.catering.Caterings;
import pl.edu.repository.club.Clubs;
import pl.edu.repository.competition.CompetitonInfos;
import pl.edu.repository.competitor.Competitors;
import pl.edu.repository.user.Users;
import pl.edu.service.accommodation.IAccommodationService;
import pl.edu.service.category.ICategoryService;
import pl.edu.service.catering.ICateringService;
import pl.edu.service.club.IClubService;
import pl.edu.service.competition.ICompetitonInfoService;
import pl.edu.service.competitor.ICompetitorService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminHomeController")
public class AdminHomeController extends BaseController{

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICateringService cateringService;

    @Autowired
    private IAccommodationService accommodationService;

    @Autowired
    private ICompetitorService competitorService;

    @Autowired
    private ICompetitonInfoService competitionInfoService;

    @ModelAttribute("competitorForm")
    public CompetitorForm form() {
        CompetitorForm competitorForm = new CompetitorForm();
        return competitorForm;
    }

    @ModelAttribute("competitors")
    public List<Competitor> competitorList() {
        List<Competitor> competitorList = competitorService.list(Competitors.findAll());
        return competitorList;
    }

    @ModelAttribute("days")
    public List<String> daysList() {
        CompetitonInfo compInfo = competitionInfoService.uniqueObject(CompetitonInfos.findAll());
        Date begin = compInfo.getBegin();
        Date end = compInfo.getEnd();

        Calendar cStart = Calendar.getInstance(),
                cStop = Calendar.getInstance();

        cStart.setTime(begin);
        cStop.setTime(end);

        List<String> days = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        do {
            days.add(df.format(cStart.getTime()));
            cStart.add(Calendar.DAY_OF_YEAR, 1);
        } while (cStart.before(cStop));

        return days;
    }

    @ModelAttribute("mealOptions")
    public List<Catering> mealList() {
        List<Catering> cateringList = cateringService.list(Caterings.findAll());
        return cateringList;
    }

    @ModelAttribute("nightOptions")
    public List<Accommodation> nightList() {
        List<Accommodation> accommodationList = accommodationService.list(Accommodations.findAll());
        return accommodationList;
    }

    @RequestMapping(value = {"/admin", "/admin/"})
    public String home(Model model){
        return "admin/index";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("competitorForm") @Valid CompetitorForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("competitorForm", form);
        return "redirect:/admin/edit/competitor_form";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("competitorForm") CompetitorForm form,
                         BindingResult bindingResult) {
        form.getCompetitor().setCategory(categoryService.uniqueObject(Categories.findAll().withId(form.getCompetitor().getCategoryId())));
        competitorService.delete(form.getCompetitor());
        return "admin/index";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=zaznacz")
    public String selectAll() {
        System.out.println("Zaznacz wszystkich!");
        return "admin/index";
    }

    @RequestMapping(value={"/admin/save_competitor", "/admin/save_competitor/"}, method=RequestMethod.POST)
    public String save_competitor(@RequestBody String jsonString) {
        System.out.println("Save competitor");
        CompetitorOptionsList options;
        ObjectMapper mapper = new ObjectMapper();
        try {
            String decodedString = URLDecoder.decode(jsonString, "UTF-8");
            System.out.println(decodedString);
            options = mapper.readValue(decodedString, CompetitorOptionsList.class);
            System.out.println(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
