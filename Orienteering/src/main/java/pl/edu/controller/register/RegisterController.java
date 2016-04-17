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
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

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
	public String register(Model model) {
		return "register";
	}
	
	@RequestMapping(value = { "/register", "/register/" }, method = RequestMethod.POST)
	public String register(RegisterForm registerForm, BindingResult result, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {

		RegisterValidator validator = new RegisterValidator();
		validator.validate(registerForm, result);

		if (!validator.hasErrors()) {
			try {
				userService.list(Users.findAll().loadWith("user"));
				userService.register(registerForm.getUser());
				return "/";
			} catch (Exception e) {
				log.warn("Warn");
				return "register";
			}
		}
		return "register";
	}
}
