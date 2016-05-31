package pl.edu.controller.home.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.controller.competitor.form.CompetitorOptionsList;
import pl.edu.controller.home.BaseHomeController;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.Catering;
import pl.edu.model.catering.reservation.CateringReservation;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.accommodation.Accommodations;
import pl.edu.repository.accommodation.reservation.AccommodationReservations;
import pl.edu.repository.category.Categories;
import pl.edu.repository.catering.Caterings;
import pl.edu.repository.catering.reservation.CateringReservations;
import pl.edu.repository.club.Clubs;
import pl.edu.repository.competition.CompetitionInfos;
import pl.edu.repository.competitor.Competitors;
import pl.edu.service.accommodation.IAccommodationService;
import pl.edu.service.accommodation.reservation.IAccommodationReservationService;
import pl.edu.service.category.ICategoryService;
import pl.edu.service.catering.ICateringService;
import pl.edu.service.catering.reservation.ICateringReservationService;
import pl.edu.service.club.IClubService;
import pl.edu.service.competition.ICompetitionInfoService;
import pl.edu.service.competitor.ICompetitorService;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminHomeController")
public class AdminHomeController extends BaseHomeController{

    @Autowired
    private IClubService clubService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ICateringService cateringService;

    @Autowired
    private IAccommodationService accommodationService;

    @Autowired
    private ICompetitorService competitorService;

    @ModelAttribute("competitorForm")
    public CompetitorForm form() {
        CompetitorForm competitorForm = new CompetitorForm();
        return competitorForm;
    }

    @ModelAttribute("competitors")
    public List<Competitor> competitorList() {
        List<Competitor> competitorList = competitorService.list(Competitors.findAll());
        competitorList.sort(((c1, c2) -> {
            if(c1.getId() > c2.getId())
                return 1;
            if(c1.getId() < c2.getId())
                return -1;
            else
                return 0;
        }));
        return competitorList;
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

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=add")
    public String add(@ModelAttribute("competitorForm") CompetitorForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("competitorForm", new CompetitorForm());
        return "redirect:/admin/edit/competitor";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("competitorForm") CompetitorForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("competitorForm", form);
        return "redirect:/admin/edit/competitor";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("competitorForm") CompetitorForm form,
                         BindingResult bindingResult) {
        form.getCompetitor().setCategory(categoryService.uniqueObject(Categories.findAll().withId(form.getCompetitor().getCategoryId())));
        form.getCompetitor().setClub(clubService.uniqueObject(Clubs.findAll().withId(form.getCompetitor().getClubId())));
        competitorService.delete(form.getCompetitor());
        return "redirect:/";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=zaznacz")
    public String selectAll() {
        System.out.println("Zaznacz wszystkich!");
        return "admin/index";
    }

    @RequestMapping(value={"/admin/save_competitor", "/admin/save_competitor/"}, method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void save_competitor(@RequestBody String jsonString) {
        System.out.println("Save competitor");
        saveCompetitorToDB(jsonString);
    }
}
