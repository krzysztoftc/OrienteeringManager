package pl.edu.controller.club.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.club.form.ClubForm;
import pl.edu.model.club.Club;
import pl.edu.repository.club.Clubs;
import pl.edu.service.club.IClubService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminClubHomeController")
public class AdminClubHomeController extends BaseController {

    @Autowired
    IClubService clubService;

    @ModelAttribute("clubForm")
    ClubForm clubForm(){
        return new ClubForm();
    }

    @ModelAttribute("clubs")
    List<Club> clubs(){
        List<Club> clubList = clubService.list(Clubs.findAll());
        return clubList;
    }

    @RequestMapping(value = {"/admin/club", "/admin/club/"})
    public String club(){
        return "admin/club";
    }

    @RequestMapping(value="/admin/club", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("clubForm") ClubForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("clubForm", form);
        return "redirect:/admin/edit/club";
    }

    @RequestMapping(value="/admin/club", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("clubForm") ClubForm form,
                         BindingResult bindingResult) {
        clubService.delete(form.getClub());
        return "admin/index";
    }
}
