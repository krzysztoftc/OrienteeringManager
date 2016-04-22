package pl.edu.controller.register;


import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.register.form.RegisterForm;
import pl.edu.controller.register.form.RegisterValidator;
import pl.edu.model.user.User;
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

import java.util.List;

@Controller
@Log4j
public class RegisterController {

	@Autowired
	private IUserService userService;
	
	@ModelAttribute("registerForm")
	public RegisterForm form() {
		return new RegisterForm();
	}

	@RequestMapping(value = { "/register", "/register/" })
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = { "/register", "/register/" }, method = RequestMethod.POST)
	public String register(RegisterForm registerForm, BindingResult result) {

		RegisterValidator validator = new RegisterValidator();
		validator.validate(registerForm, result);
        String resultView = "register";
		if (!validator.hasErrors()) {
			try {
				List<User> users = userService.list(Users.findAll().withEmail(registerForm.getUser().getEmail()));

                if(users.size() == 0) {
                    userService.register(registerForm.getUser());
                    resultView = "redirect:/";
                }

			} catch (Exception e) {
				log.warn("Warn");
                e.printStackTrace();
//                System.out.println();
			}
		}
		return resultView;
	}
}
