package pl.edu.controller.competitor.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import pl.edu.model.competitor.Competitor;
import pl.edu.mvc.AbstractForm;

import java.util.List;

public class CompetitorListForm extends AbstractForm {

	private static final long serialVersionUID = 1574688377467056255L;

	@Getter @Setter
	private List<Competitor> competitors;

    public CompetitorListForm(){
//        competitor = new Competitor();
    }

	@Override
	public String getID() {
		return new Md5PasswordEncoder().encodePassword(competitors.hashCode() + "", "sdfNOghELOjklkjuhLOGINygtfrLOLrtgyhjk");
	}

}
