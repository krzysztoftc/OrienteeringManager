package pl.edu.controller.admin.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.competition.CompetitonInfo;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.competition.CompetitonInfos;
import pl.edu.repository.competitor.Competitors;
import pl.edu.repository.user.Users;
import pl.edu.service.competition.ICompetitonInfoService;
import pl.edu.service.competitor.ICompetitorService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class AdminHomeController {

    @Autowired
    private ICompetitorService competitorService;

    @Autowired
    private ICompetitonInfoService competitionInfoService;

    @ModelAttribute("competitorForm")
    public CompetitorForm form() {
        return new CompetitorForm();
    }

    @ModelAttribute("competitors")
    public List<Competitor> competitorList() {
        return competitorService.list(Competitors.findAll());
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

        for (String day: days) {
            System.out.println(day);
        }

        return days;
    }

    @RequestMapping(value = {"/admin", "/admin/"})
    public String home(Model model){
        List<String> days = new ArrayList<>();
        days.add("Poniedziałek");
        days.add("Wtorek");
        days.add("Sroda");
        days.add("Czwartek");
        days.add("Piatek");
        model.addAttribute(days);
        for ( String day : days) {
            System.out.println(day);
        }
        return "admin/index";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("competitorForm") CompetitorForm form,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("competitorForm", form);
        return "redirect:/admin/edit/competitor";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("competitorForm") CompetitorForm form) {
        competitorService.delete(form.getCompetitor());
        return "admin/index";
    }
}
