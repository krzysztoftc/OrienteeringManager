package pl.edu.controller.competition.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.competition.ICompetitionInfoService;
import pl.edu.validator.CommonValidator;

public class CompetitionValidator extends CommonValidator {

	@Autowired
    ICompetitionInfoService competitionService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CompetitionInfoForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        CompetitionInfoForm form = (CompetitionInfoForm) target;
		if (StringUtils.isBlank(form.getCompetitionInfo().getName())) {
			errors.rejectValue("competition.name", "competition.name.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getCompetitionInfo().getAddress())) {
            errors.rejectValue("competition.address", "competition.address.cannot.be.null");
        }
        if (form.getCompetitionInfo().getDescription() == null) {
            errors.rejectValue("competition.description", "competition.description.cannot.be.null");
        }
	}
}
