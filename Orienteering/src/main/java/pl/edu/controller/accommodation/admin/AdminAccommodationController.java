package pl.edu.controller.accommodation.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.accommodation.form.AccommodationForm;
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.service.accommodation.IAccommodationService;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminAccommodationController")
public class AdminAccommodationController extends BaseController{

    @Autowired
    IAccommodationService accommodationService;

    @ModelAttribute
    AccommodationForm accommodationForm(){
        return new AccommodationForm();
    }

    @RequestMapping(value = {"/admin/accommodation", "/admin/accommodation/"})
    public String accommodation(){
        return "admin/accommodation";
    }

    @RequestMapping(value = {"/admin/edit/accommodation", "/admin/edit/accommodation/"})
    public String accommodationRegister(@ModelAttribute("accommodationForm") AccommodationForm form,
                       BindingResult bindingResult){
        return "admin/edit/accommodation_form";
    }

    @RequestMapping(value = {"/admin/edit/accommodation", "/admin/edit/accommodation/"},
            method= RequestMethod.POST, params="action=save")
    public String saveAccommodation(@ModelAttribute("accommodationForm") AccommodationForm form,
                                 BindingResult bindingResult) {
        String resultView = "redirect:/admin/accommodation";
        try {
            accommodationService.saveOrUpdate(form.getAccommodation());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/accommodation_form";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/accommodation", "/admin/edit/accommodation/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelAccommodation() {
        return "redirect:/admin/accommodation";
    }

}
