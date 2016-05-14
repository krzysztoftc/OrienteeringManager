package pl.edu.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.model.user.Role;
import pl.edu.utils.RoleUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * Created by bartosz on 09.04.16.
 */

@Controller("mainController")
public class MainController {

    @RequestMapping("/")
    public String homepage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String resultView = "index";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated()){
            Collection authorities = authentication.getAuthorities();
            for (Role role : Role.values()) {
                SimpleGrantedAuthority simpleGrantedAuthority =
                        new SimpleGrantedAuthority(role.getCodeWithPrefix());
                if(authorities.contains(simpleGrantedAuthority)){
                    resultView = RoleUtils.getHomeFromRole(role);
                }
            }
        }
        model.addAttribute("attribute", "Zmienna z modelu");
        return resultView;
    }
}