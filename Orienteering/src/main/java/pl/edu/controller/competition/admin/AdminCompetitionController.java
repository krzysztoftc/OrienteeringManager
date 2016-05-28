package pl.edu.controller.competition.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.competition.form.CompetitionForm;
import pl.edu.service.competition.ICompetitonInfoService;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminCompetitionController")
public class AdminCompetitionController extends BaseController {

    @Autowired
    ICompetitonInfoService competitionService;

    @ModelAttribute
    CompetitionForm competitionForm(){
        return new CompetitionForm();
    }

    @RequestMapping(value = {"/admin/competition", "/admin/competition/"})
    public String competition(){
        return "admin/competition";
    }

    @RequestMapping(value = {"/admin/edit/competition", "/admin/edit/competition/"})
    public String competitionRegister(@ModelAttribute("competitionForm") CompetitionForm form,
                                        BindingResult bindingResult){
        return "admin/edit/competition_form";
    }

    @RequestMapping(value = {"/admin/edit/competition", "/admin/edit/competition/"},
            method= RequestMethod.POST, params="action=save")
    public String savecompetition(@ModelAttribute("competitionForm") CompetitionForm form,
                                    BindingResult bindingResult) {
        String resultView = "redirect:/admin/competition";
        try {
            competitionService.saveOrUpdate(form.getCompetition());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/competition_form";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/competition", "/admin/edit/competition/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelcompetition() {
        return "redirect:/admin/competition";
    }
}
