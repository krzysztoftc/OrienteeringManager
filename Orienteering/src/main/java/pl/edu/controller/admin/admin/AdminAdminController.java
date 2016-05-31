package pl.edu.controller.admin.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.admin.form.AdminForm;
import pl.edu.model.user.User;
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminAdminController")
public class AdminAdminController extends BaseController {

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

    @RequestMapping(value = {"/admin/edit/admin", "/admin/edit/admin/"})
    public String adminRegister(@ModelAttribute("adminForm") AdminForm form,
                                        BindingResult bindingResult){
        return "admin/edit/admin_form";
    }

    @RequestMapping(value = {"/admin/edit/admin", "/admin/edit/admin/"},
            method= RequestMethod.POST, params="action=save")
    public String saveUser(@ModelAttribute("adminForm") AdminForm form,
                                    BindingResult bindingResult) {
//        String resultView = "redirect:/admin/admin";
        String resultView = "redirect:/admin";
        try {
            userService.saveOrUpdate(form.getAdmin());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/admin_form";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/admin", "/admin/edit/admin/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelUser() {
        return "redirect:/admin/admin";
    }
}
