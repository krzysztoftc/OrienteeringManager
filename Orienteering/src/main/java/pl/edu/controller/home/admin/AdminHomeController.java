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
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.accommodation.availability.AccommodationAvailability;
import pl.edu.model.accommodation.reservation.AccommodationReservation;
import pl.edu.model.catering.Catering;
import pl.edu.model.catering.availability.CateringAvailability;
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
import pl.edu.service.catering.availability.ICateringAvailabilityService;
import pl.edu.service.catering.reservation.ICateringReservationService;
import pl.edu.service.club.IClubService;
import pl.edu.service.competition.ICompetitionInfoService;
import pl.edu.service.competitor.ICompetitorService;

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
    private ICateringReservationService cateringReservationService;

    @Autowired
    private IAccommodationReservationService accommodationReservationService;

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
        return "admin/index";
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
        try {

            String decodedString = URLDecoder.decode(jsonString, "UTF-8");
            System.out.println(decodedString);

            ObjectMapper mapper = new ObjectMapper();
            CompetitorOptionsList options = mapper.readValue(decodedString, CompetitorOptionsList.class);

            updateCateringReservations(options);
            updateAccommodationReservations(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return null;
    }

    private void updateCateringReservations(CompetitorOptionsList options){
        // Getting list of current catering reservations
        List<CateringReservation> cateringReservationsList =
                cateringReservationService.list(CateringReservations.findAll().withCompetitorId(options.getCompetitor()));

        // Removing old catering reservations
        for(CateringReservation cr : cateringReservationsList){
            cateringReservationService.delete(cr);
        }
        System.out.println("Deleted old catering reservations");

        // Adding new catering reservations
        for(Long id : options.getCaterings()){
            CateringReservation cr = new CateringReservation();
            cr.setCompetitorId(options.getCompetitor());
            cr.setCateringAvailabilityId(id);
            cateringReservationService.save(cr);
        }
        System.out.println("Added new catering reservations");
    }

    private void updateAccommodationReservations(CompetitorOptionsList options){
        // Getting list of current accommodation reservations
        List<AccommodationReservation> accommodationReservationsList =
                accommodationReservationService.list(AccommodationReservations.findAll().withCompetitorId(options.getCompetitor()));

        // Removing old accommodation reservations
        for(AccommodationReservation ar : accommodationReservationsList){
            accommodationReservationService.delete(ar);
        }
        System.out.println("Deleted old accommodation reservations");

        // Adding new accommodation reservations
        for(Long id : options.getNights()){
            AccommodationReservation ar = new AccommodationReservation();
            ar.setCompetitorId(options.getCompetitor());
            ar.setAccommodationAvailability(id);
            accommodationReservationService.save(ar);
        }
        System.out.println("Added new accommodation reservations");
    }
}
