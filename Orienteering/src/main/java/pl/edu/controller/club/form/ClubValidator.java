package pl.edu.controller.club.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.club.IClubService;
import pl.edu.validator.CommonValidator;

public class ClubValidator extends CommonValidator {

	@Autowired
    IClubService clubService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ClubForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        ClubForm form = (ClubForm) target;
		if (StringUtils.isBlank(form.getClub().getName())) {
			errors.rejectValue("club.name", "club.name.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getClub().getAddress())) {
            errors.rejectValue("club.address", "club.address.cannot.be.null");
        }
	}
}
