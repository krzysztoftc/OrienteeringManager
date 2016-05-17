package pl.edu.controller.clubs.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.competitor.Competitors;
import pl.edu.repository.user.Users;
import pl.edu.service.competitor.ICompetitorService;
import pl.edu.service.user.IUserService;
import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("clubsHomeController")
public class ClubsHomeController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICompetitorService competitorService;

    @ModelAttribute("competitorForm")
    public CompetitorForm form() {
        return new CompetitorForm();
    }

    @ModelAttribute("competitors")
    public List<Competitor> competitorList() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long clubId = userService.uniqueObject(Users.findAll().withEmail(user.getUsername())).getClubId();
        return competitorService.list(Competitors.findAll().withClubId(clubId));
    }

    @RequestMapping(value = {"/clubs", "/clubs/"})
    public String home(){
        return "clubs/index";
    }

}
