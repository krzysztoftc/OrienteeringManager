package pl.edu.controller.accommodation.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.accommodation.form.AccommodationForm;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.repository.accommodation.Accommodations;
import pl.edu.service.accommodation.IAccommodationService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminAccommodationHomeController")
public class AdminAccommodationHomeController extends BaseController{

    @Autowired
    IAccommodationService accommodationService;

    @ModelAttribute("accommodationForm")
    AccommodationForm accommodationForm(){
        return new AccommodationForm();
    }

    @ModelAttribute("accommodations")
    List<Accommodation> accommodations(){
        List<Accommodation> accommodationList = accommodationService.list(Accommodations.findAll());
        return accommodationList;
    }

    @RequestMapping(value = {"/admin/accommodation", "/admin/accommodation/"})
    public String accommodation(){
        return "admin/accommodation";
    }

    @RequestMapping(value="/admin/accommodation", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("accommodationForm") AccommodationForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("accommodationForm", form);
        return "redirect:/admin/edit/accommodation";
    }

    @RequestMapping(value="/admin/accommodation", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("accommodationForm") AccommodationForm form,
                         BindingResult bindingResult) {
        accommodationService.delete(form.getAccommodation());
        return "redirect:/admin/accommodation";
    }
}
