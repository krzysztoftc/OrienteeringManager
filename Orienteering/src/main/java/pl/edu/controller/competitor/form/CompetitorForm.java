package pl.edu.controller.competitor.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.competitor.Competitor;
import pl.edu.mvc.AbstractForm;

public class CompetitorForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private Competitor competitor;

    public CompetitorForm(){
//        competitor = new Competitor();
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(competitor.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
