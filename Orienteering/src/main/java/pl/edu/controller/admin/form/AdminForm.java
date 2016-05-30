package pl.edu.controller.admin.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.user.User;
import pl.edu.mvc.AbstractForm;

public class AdminForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private User admin;

    public AdminForm(){
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(admin.getId() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
