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
import pl.edu.controller.competitor.form.CompetitorForm;
import pl.edu.model.catering.Catering;
import pl.edu.repository.category.Categories;
import pl.edu.repository.catering.Caterings;
import pl.edu.service.catering.ICateringService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminCateringController")
public class AdminCateringController extends BaseController {

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

    @RequestMapping(value = {"/admin/edit/catering", "/admin/edit/catering/"})
    public String cateringRegister(@ModelAttribute("cateringForm") CateringForm form,
                                        BindingResult bindingResult){
        return "admin/edit/catering_form";
    }

    @RequestMapping(value = {"/admin/edit/catering", "/admin/edit/catering/"},
            method= RequestMethod.POST, params="action=save")
    public String saveCatering(@ModelAttribute("cateringForm") CateringForm form,
                                    BindingResult bindingResult) {
        String resultView = "redirect:/admin/catering";
        try {
            cateringService.saveOrUpdate(form.getCatering());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/catering_form";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/catering", "/admin/edit/catering/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelCatering() {
        return "redirect:/admin/catering";
    }
}
