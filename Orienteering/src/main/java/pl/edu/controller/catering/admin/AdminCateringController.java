package pl.edu.controller.catering.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.catering.form.CateringForm;
import pl.edu.service.catering.ICateringService;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminCateringController")
public class AdminCateringController extends BaseController {

    @Autowired
    ICateringService cateringService;

    @ModelAttribute
    CateringForm cateringForm(){
        return new CateringForm();
    }

    @RequestMapping(value = {"/admin/catering", "/admin/catering/"})
    public String catering(){
        return "admin/catering";
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
