package pl.edu.controller.competition.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.competition.CompetitionInfo;
import pl.edu.mvc.AbstractForm;

public class CompetitionForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private CompetitionInfo competition;

    public CompetitionForm(){
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(competition.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
