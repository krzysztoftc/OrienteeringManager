package pl.edu.controller.admin.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.user.IUserService;
import pl.edu.validator.CommonValidator;

public class AdminValidator extends CommonValidator {

	@Autowired
	IUserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(AdminForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        AdminForm form = (AdminForm) target;
		if (StringUtils.isBlank(form.getAdmin().getEmail())) {
			errors.rejectValue("club.email", "club.email.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getAdmin().getPassword())) {
            errors.rejectValue("club.password", "club.password.cannot.be.null");
        }
	}
}
