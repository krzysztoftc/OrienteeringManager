package pl.edu.controller.admin.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.admin.form.AdminForm;
import pl.edu.model.user.User;
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminAdminHomeController")
public class AdminAdminHomeController extends BaseController {

    @Autowired
    IUserService userService;

    @ModelAttribute("adminForm")
    AdminForm adminForm(){
        return new AdminForm();
    }

    @ModelAttribute("admins")
    List<User> admins(){
        List<User> adminList = userService.list(Users.findAll());
        return adminList;
    }

    @RequestMapping(value = {"/admin/admin", "/admin/admin/"})
    public String admin(){
        return "admin/admin";
    }

    @RequestMapping(value="/admin/admin", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("adminForm") AdminForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("adminForm", form);
        return "redirect:/admin/edit/admin";
    }

    @RequestMapping(value="/admin/admin", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("adminForm") AdminForm form,
                         BindingResult bindingResult) {
        userService.delete(form.getAdmin());
        return "admin/index";
    }
}
