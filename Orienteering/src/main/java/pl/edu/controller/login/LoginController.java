package pl.edu.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.controller.login.form.LoginForm;
import pl.edu.controller.login.form.LoginValidator;
import pl.edu.model.user.User;
import pl.edu.service.user.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by bartosz on 11.04.16.
 */
@Controller("loginController")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @ModelAttribute("loginForm")
    public LoginForm form() {
        return new LoginForm();
    }

    @RequestMapping(value = { "/login", "/login/" })
    public String homepage(Model model) {
        System.out.println("Homepage");
        return "login";
    }

    @RequestMapping(value = { "/login", "/login/" }, method = RequestMethod.POST)
    public String login(LoginForm loginForm, BindingResult result, Model model,
                        RedirectAttributes redirectAttributes, HttpServletRequest request,
                        HttpServletResponse response) {
        System.out.println("POST Homepage");
        LoginValidator validator = new LoginValidator();
        validator.validate(loginForm, result);
        String resultView = "index";
        if (!validator.hasErrors()) {

            Authentication authenticate = null;
            try {
                // sprawdzamy czy haslo i user sie zgadza (z sola)
                authenticate = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginForm.getUser().getEmail(),
                                loginForm.getUser().getPassword()));

                if(authenticate.isAuthenticated()){
                    SecurityContextHolder.getContext().setAuthentication(authenticate);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
                    resultView = "index";
                }
            } catch (BadCredentialsException e) {
                System.out.println(e.getClass());
                resultView = "index";

            } catch (AccountExpiredException e){
                System.out.println(e.getClass());
                resultView = "index";
            } catch (LockedException e){
                System.out.println(e.getClass());
                resultView = "index";
            } catch (Exception e){
                System.out.println(e.getClass());
                resultView = "index";
            }
        }
        return resultView;
    }
}
