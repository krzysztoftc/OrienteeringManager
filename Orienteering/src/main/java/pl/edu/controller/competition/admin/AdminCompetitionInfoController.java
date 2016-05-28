package pl.edu.controller.competition.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.competition.form.CompetitionInfoForm;
import pl.edu.service.competition.ICompetitionInfoService;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminCompetitionInfoController")
public class AdminCompetitionInfoController extends BaseController {

    @Autowired
    ICompetitionInfoService competitionInfoService;

    @ModelAttribute("competitionInfoForm")
    CompetitionInfoForm competitionInfoForm(){
        return new CompetitionInfoForm();
    }

    @RequestMapping(value = {"/admin/competition", "/admin/competition/"})
    public String competitionInfo(){
        return "admin/competition";
    }

    @RequestMapping(value = {"/admin/edit/competition", "/admin/edit/competition/"})
    public String competitionRegister(@ModelAttribute("competitionForm") CompetitionInfoForm form,
                                        BindingResult bindingResult){
        return "admin/edit/competition_form";
    }

    @RequestMapping(value = {"/admin/edit/competition", "/admin/edit/competition/"},
            method= RequestMethod.POST, params="action=save")
    public String saveCompetitionInfo(@ModelAttribute("competitionForm") CompetitionInfoForm form,
                                    BindingResult bindingResult) {
        String resultView = "redirect:/admin/competition";
        try {
            competitionInfoService.saveOrUpdate(form.getCompetitionInfo());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/competition_form";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/competition", "/admin/edit/competition/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelCompetitionInfo() {
        return "redirect:/admin/competition";
    }
}
