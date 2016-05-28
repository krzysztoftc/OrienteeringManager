package pl.edu.controller.competition.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.competition.ICompetitonInfoService;
import pl.edu.validator.CommonValidator;

public class CompetitionValidator extends CommonValidator {

	@Autowired
	ICompetitonInfoService competitionService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CompetitionForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        CompetitionForm form = (CompetitionForm) target;
		if (StringUtils.isBlank(form.getCompetition().getName())) {
			errors.rejectValue("competition.name", "competition.name.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getCompetition().getAddress())) {
            errors.rejectValue("competition.address", "competition.address.cannot.be.null");
        }
        if (form.getCompetition().getDescription() == null) {
            errors.rejectValue("competition.description", "competition.description.cannot.be.null");
        }
	}
}
