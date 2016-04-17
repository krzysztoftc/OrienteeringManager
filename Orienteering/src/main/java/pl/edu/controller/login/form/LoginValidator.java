package pl.edu.controller.login.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.user.IUserService;
import pl.edu.validator.CommonValidator;

public class LoginValidator extends CommonValidator {

	@Autowired
	IUserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(LoginForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

		LoginForm form = (LoginForm) target;

		if (StringUtils.isBlank(form.getUser().getEmail())) {
			errors.rejectValue("user.username", "user.email.cannot.be.null");
		}

		if (StringUtils.isBlank(form.getUser().getPassword())) {
			errors.rejectValue("user.password", "user.password.cannot.be.null");
		}
	}
}
