package pl.edu.controller.accommodation.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.accommodation.Accommodation;
import pl.edu.model.competitor.Competitor;
import pl.edu.mvc.AbstractForm;

public class AccommodationForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private Accommodation accommodation;

    public AccommodationForm(){
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(accommodation.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
