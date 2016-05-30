package pl.edu.controller.user.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.BaseController;
import pl.edu.controller.user.form.UserForm;
import pl.edu.model.user.User;
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminUserController")
public class AdminUserController extends BaseController {

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

    @RequestMapping(value = {"/admin/edit/user", "/admin/edit/user/"})
    public String userRegister(@ModelAttribute("userForm") UserForm form,
                                        BindingResult bindingResult){
        return "admin/edit/user_form";
    }

    @RequestMapping(value = {"/admin/edit/user", "/admin/edit/user/"},
            method= RequestMethod.POST, params="action=save")
    public String saveUser(@ModelAttribute("userForm") UserForm form,
                                    BindingResult bindingResult) {
        String resultView = "redirect:/admin/user";
        try {
            userService.saveOrUpdate(form.getUser());
        }catch(Exception e){
            e.printStackTrace();
            resultView = "/admin/edit/user_form";
        }
        return resultView;
    }

    @RequestMapping(value = {"/admin/edit/user", "/admin/edit/user/"},
            method=RequestMethod.POST, params="action=cancel")
    public String cancelUser() {
        return "redirect:/admin/user";
    }
}
