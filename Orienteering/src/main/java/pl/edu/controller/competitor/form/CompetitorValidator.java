package pl.edu.controller.competitor.form;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import pl.edu.service.competitor.ICompetitorService;
import pl.edu.validator.CommonValidator;

public class CompetitorValidator extends CommonValidator {

	@Autowired
    ICompetitorService competitorService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CompetitorForm.class);
	}

	@Override
	public void validateForm(Object target, Errors errors) {

        CompetitorForm form = (CompetitorForm) target;
		if (StringUtils.isBlank(form.getCompetitor().getName())) {
			errors.rejectValue("competitor.name", "competitor.name.cannot.be.null");
		}
        if (StringUtils.isBlank(form.getCompetitor().getSurname())) {
            errors.rejectValue("competitor.surname", "competitor.surname.cannot.be.null");
        }
        if (form.getCompetitor().getBirthYear() == null) {
            errors.rejectValue("competitor.birth_year", "competitor.birth_year.cannot.be.null");
        }
        if (form.getCompetitor().getGender() != 'F' ||
            form.getCompetitor().getGender() != 'M') {
            errors.rejectValue("competitor.gender", "competitor.gender.must.be.m.or.f");
        }
        if (form.getCompetitor().getCategory() == null) {
            errors.rejectValue("competitor.category", "competitor.category.cannot.be.null");
        }
	}
}
