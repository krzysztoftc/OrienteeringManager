package pl.edu.controller.user.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.user.User;
import pl.edu.mvc.AbstractForm;

public class UserForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private User user;

	@Getter @Setter
	private String newEmail;

	@Getter @Setter
	private String newPass;

	@Getter @Setter
	private String newPassCopy;

    public UserForm(){
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(user.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
