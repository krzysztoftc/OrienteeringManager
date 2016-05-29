package pl.edu.controller.club.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.club.Club;
import pl.edu.mvc.AbstractForm;

public class ClubForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private Club club;

    public ClubForm(){
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(club.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
