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

        // User
		if (StringUtils.isBlank(form.getUser().getEmail())) {
			errors.rejectValue("user.email", "user.email.cannot.be.null");
		}
				
		if (StringUtils.isBlank(form.getUser().getPassword())) {
			errors.rejectValue("user.password", "user.password.cannot.be.null");
		}
		if (StringUtils.isBlank(form.getSecondPassword())) {
			errors.rejectValue("secondPassword", "user.secondPassword.cannot.be.null");
		}
		
		if (!form.getUser().getPassword().equals(form.getSecondPassword())) {
			errors.rejectValue("user.password", "user.password.cannot.be.null");
		}

        // Club
        if(StringUtils.isBlank(form.getClub().getName())){
            errors.rejectValue("club.name", "club.name.cannot.be.null");
        }

        if(StringUtils.isBlank(form.getClub().getAddress())){
            errors.rejectValue("club.address", "club.address.cannot.be.null");
        }

        if(StringUtils.isBlank(form.getClub().getAgentName())){
            errors.rejectValue("club.agentName", "club.agentName.cannot.be.null");
        }

        if(StringUtils.isBlank(form.getClub().getAgentSurname())){
            errors.rejectValue("club.agentSurname", "club.agentSurname.cannot.be.null");
        }

        if(StringUtils.isBlank(form.getClub().getClubNumber())){
            errors.rejectValue("club.clubNumber", "club.clubNumber.cannot.be.null");
        }

        if(StringUtils.isBlank(form.getClub().getPhoneNumber())){
            errors.rejectValue("club.phoneNumber", "club.phoneNumber.cannot.be.null");
        }
	}
}
