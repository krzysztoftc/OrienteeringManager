package pl.edu.controller.catering.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.catering.form.CateringForm;
import pl.edu.model.catering.Catering;
import pl.edu.repository.catering.Caterings;
import pl.edu.service.catering.ICateringService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminCateringHomeController")
public class AdminCateringHomeController extends BaseController {

    @Autowired
    ICateringService cateringService;

    @ModelAttribute("cateringForm")
    CateringForm cateringForm(){
        return new CateringForm();
    }

    @ModelAttribute("caterings")
    List<Catering> caterings(){
        List<Catering> cateringList = cateringService.list(Caterings.findAll());
        return cateringList;
    }

    @RequestMapping(value = {"/admin/catering", "/admin/catering/"})
    public String catering(){
        return "admin/catering";
    }

    @RequestMapping(value="/admin/catering", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("cateringForm") CateringForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("cateringForm", form);
        return "redirect:/admin/edit/catering";
    }

    @RequestMapping(value="/admin/catering", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("cateringForm") CateringForm form,
                         BindingResult bindingResult) {
        cateringService.delete(form.getCatering());
        return "redirect:/admin/catering";
    }
}
