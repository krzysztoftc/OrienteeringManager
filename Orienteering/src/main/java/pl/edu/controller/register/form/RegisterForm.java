package pl.edu.controller.register.form;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.user.User;
import pl.edu.mvc.AbstractForm;

public class RegisterForm extends AbstractForm {

	private static final long serialVersionUID = -6531446778265375752L;

	@Getter
	@Setter
	private User user;
	
	@Getter
	@Setter
	private String secondPassword;
	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(user.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
