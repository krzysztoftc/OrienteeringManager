package pl.edu.controller.home.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.catering.Catering;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.accommodation.Accommodations;
import pl.edu.repository.category.Categories;
import pl.edu.repository.catering.Caterings;
import pl.edu.repository.competition.CompetitionInfos;
import pl.edu.repository.competitor.Competitors;
import pl.edu.service.accommodation.IAccommodationService;
import pl.edu.service.category.ICategoryService;
import pl.edu.service.catering.ICateringService;
import pl.edu.service.competition.ICompetitionInfoService;
import pl.edu.service.competitor.ICompetitorService;

import javax.validation.Valid;
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
    private ICompetitionInfoService competitionInfoService;

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
        CompetitionInfo compInfo = competitionInfoService.uniqueObject(CompetitionInfos.findAll());
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
        return "redirect:/admin/edit/competitor";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("competitorForm") CompetitorForm form,
                         BindingResult bindingResult) {
        form.getCompetitor().setCategory(categoryService.uniqueObject(Categories.findAll().withId(form.getCompetitor().getCategoryId())));
        competitorService.delete(form.getCompetitor());
        return "admin/index";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=add")
    public String selectAll() {
        System.out.println("Dodaj nowego!");
        return "admin/index";
    }
}
