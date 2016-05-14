package pl.edu.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.controller.login.form.LoginForm;
import pl.edu.controller.login.form.LoginValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by bartosz on 11.04.16.
 */
@Controller("loginController")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("loginForm")
    public LoginForm form() {
        return new LoginForm();
    }

    @RequestMapping(value = { "/login", "/login/" })
    public String homepage() {
        System.out.println("Homepage");
        return "login";
    }

    @RequestMapping(value = { "/login", "/login/" }, method = RequestMethod.POST)
    public String login(LoginForm loginForm, BindingResult result, HttpServletRequest request) {
        System.out.println("POST Homepage");
        LoginValidator validator = new LoginValidator();
        validator.validate(loginForm, result);
        String resultView = "login";
        if (!validator.hasErrors()) {

            Authentication authenticate = null;
            try {
                // sprawdzamy czy haslo i user sie zgadza
                authenticate = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginForm.getUser().getEmail(),
                                loginForm.getUser().getPassword()));

                if(authenticate.isAuthenticated()){
                    SecurityContextHolder.getContext().setAuthentication(authenticate);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
                    resultView = "redirect:/";
                }
            } catch (BadCredentialsException e) {
                System.out.println(e.getClass());
                resultView = "login";

            } catch (AccountExpiredException e){
                System.out.println(e.getClass());
                resultView = "login";
            } catch (LockedException e){
                System.out.println(e.getClass());
                resultView = "login";
            } catch (Exception e){
                System.out.println(e.getClass());
                resultView = "login";
            }
        }
        return resultView;
    }
}
