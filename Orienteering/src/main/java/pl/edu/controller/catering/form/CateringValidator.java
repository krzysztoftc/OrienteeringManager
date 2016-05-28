package pl.edu.controller.catering.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.catering.ICateringService;
import pl.edu.validator.CommonValidator;

public class CateringValidator extends CommonValidator {

	@Autowired
    ICateringService cateringService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CateringForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        CateringForm form = (CateringForm) target;
		if (StringUtils.isBlank(form.getCatering().getName())) {
			errors.rejectValue("catering.name", "catering.name.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getCatering().getAddress())) {
            errors.rejectValue("catering.address", "catering.address.cannot.be.null");
        }
        if (form.getCatering().getDescription() == null) {
            errors.rejectValue("catering.description", "catering.description.cannot.be.null");
        }
	}
}
