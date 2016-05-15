package pl.edu.controller.clubs.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = {"/clubs", "/clubs/"})
    public String home(Model model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String email.
        Long clubId = userService.uniqueObject(Users.findAll().withEmail(user.getUsername())).getClubId();
        List<Competitor> competitors = competitorService.list(Competitors.findAll().withClubId(clubId));
        model.addAttribute("competitors", competitors);
        return "index";
    }

}
