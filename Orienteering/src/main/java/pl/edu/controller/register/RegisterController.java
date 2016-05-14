package pl.edu.controller.register;


import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.register.form.RegisterForm;
import pl.edu.controller.register.form.RegisterValidator;
import pl.edu.model.club.Club;
import pl.edu.model.user.User;
import pl.edu.repository.club.Clubs;
import pl.edu.repository.user.Users;
import pl.edu.service.club.IClubService;
import pl.edu.service.user.IUserService;

import java.util.List;

@Controller
@Log4j
public class RegisterController {

	@Autowired
	private IUserService userService;

    @Autowired
    private IClubService clubService;
	
	@ModelAttribute("registerForm")
	public RegisterForm form() {
		return new RegisterForm();
	}

	@RequestMapping(value = { "/register", "/register/" })
	public String register(User user) {
        return "register";
	}
	
	@RequestMapping(value = { "/register", "/register/" }, method = RequestMethod.POST)
	public String register(RegisterForm registerForm, BindingResult result) {

		RegisterValidator validator = new RegisterValidator();
		validator.validate(registerForm, result);
        String resultView = "register";
		if (!validator.hasErrors()) {
			try {
//				List<User> users = userService.list(Users.findAll().withEmail(registerForm.getUser().getEmail()));
                if(!userExists(registerForm.getUser())) {
//                    List<Club> clubs = clubService.list(Clubs.findAll().withClubNumber(registerForm.getClub().getClubNumber()));
                    if(!clubExists(registerForm.getClub())){
                        clubService.register(registerForm.getClub());
                        Club club = clubService.uniqueObject(Clubs.findAll().withClubNumber(registerForm.getClub().getClubNumber()));

                        if(club != null){
                            User user = registerForm.getUser();
                            user.setClubId(club.getId());
                            userService.register(user);
                            resultView = "redirect:/";
                        }
                    }
                }

			} catch (Exception e) {
				log.warn("Warn");
                e.printStackTrace();
//                System.out.println();
			}
		}
		return resultView;
	}

    private boolean userExists(User user){
        return userService.exists(Users.findAll().withEmail(user.getEmail()));
    }

    private boolean clubExists(Club club){
        return clubService.exists(Clubs.findAll().withClubNumber(club.getClubNumber()));
    }


}
