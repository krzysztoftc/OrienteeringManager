package pl.edu.controller.register.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.user.IUserService;
import pl.edu.validator.CommonValidator;

public class RegisterValidator extends CommonValidator {

	@Autowired
	private IUserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(RegisterForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

		RegisterForm form = (RegisterForm) target;

		if (StringUtils.isBlank(form.getUser().getEmail())) {
			errors.rejectValue("user.email", "user.email.cannot.be.null");
		}
				
		if (StringUtils.isBlank(form.getUser().getPassword())) {
			errors.rejectValue("user.password", "user.password.cannot.be.null");
		}
		if (StringUtils.isBlank(form.getSecondPassword())) {
			errors.rejectValue("secondPassword", "user.password.cannot.be.null");
		}
		
		if (!form.getUser().getPassword().equals(form.getSecondPassword())) {
			errors.rejectValue("user.password", "user.password.cannot.be.null");
		}
	}
}
