package pl.edu.controller.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.user.User;
import pl.edu.mvc.AbstractForm;

public class LoginForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private User user;
	
	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(user.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
