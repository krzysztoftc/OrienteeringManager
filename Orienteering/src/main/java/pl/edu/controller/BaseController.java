package pl.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.edu.model.club.Club;
import pl.edu.repository.user.Users;
import pl.edu.service.user.IUserService;

/**
 * Created by bartosz on 26.05.16.
 */
public abstract class BaseController {

    @Autowired
    IUserService userService;

    @ModelAttribute("clubData")
    public Club clubData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            User userDetails = (User) authentication.getPrincipal();
            return userService.uniqueObject(Users.findAll().withEmail(userDetails.getUsername())).getClub();
        }
        catch(ClassCastException e){
        }
        return new Club();
//        return user;
    }
}
