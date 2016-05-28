package pl.edu.controller.accommodation.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.accommodation.IAccommodationService;
import pl.edu.validator.CommonValidator;

public class AccommodationValidator extends CommonValidator {

	@Autowired
    IAccommodationService accommodationService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(AccommodationForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        AccommodationForm form = (AccommodationForm) target;
		if (StringUtils.isBlank(form.getAccommodation().getName())) {
			errors.rejectValue("accommodation.name", "accommodation.name.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getAccommodation().getAddress())) {
            errors.rejectValue("accommodation.address", "accommodation.address.cannot.be.null");
        }
        if (form.getAccommodation().getDescription() == null) {
            errors.rejectValue("accommodation.description", "accommodation.description.cannot.be.null");
        }
        if (form.getAccommodation().getPlaces() == null) {
            errors.rejectValue("accommodation.places", "accommodation.places.cannot.be.null");
        }
	}
}
