package pl.edu.controller.user.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.BaseController;
import pl.edu.controller.user.form.UserForm;
import pl.edu.model.user.User;
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminUserHomeController")
public class AdminUserHomeController extends BaseController {

    @Autowired
    IUserService userService;

    @ModelAttribute("userForm")
    UserForm userForm(){
        return new UserForm();
    }

    @ModelAttribute("users")
    List<User> users(){
        List<User> userList = userService.list(Users.findAll());
        return userList;
    }

    @RequestMapping(value = {"/admin/user", "/admin/user/"})
    public String user(){
        return "admin/user";
    }

    @RequestMapping(value="/admin/user", method=RequestMethod.POST, params="action=edit")
    public String edit(@ModelAttribute("userForm") UserForm form,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("userForm", form);
        return "redirect:/admin/edit/user";
    }

    @RequestMapping(value="/admin/user", method=RequestMethod.POST, params="action=delete")
    public String delete(@ModelAttribute("userForm") UserForm form,
                         BindingResult bindingResult) {
        userService.delete(form.getUser());
        return "admin/index";
    }
}
