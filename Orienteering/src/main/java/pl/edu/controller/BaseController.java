package pl.edu.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

    @ModelAttribute("loggedUsername")
    public pl.edu.model.user.User loggedUsername(){

        pl.edu.model.user.User loggedUsername = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            User userDetails = (User) authentication.getPrincipal();
            loggedUsername = userService.uniqueObject(Users.findAll().withEmail(userDetails.getUsername()));
        }
        catch(Exception e){
        }

        if( loggedUsername == null)
            loggedUsername = new pl.edu.model.user.User();

        if(loggedUsername.getType() == null)
            loggedUsername.setType("NONE");

        if(loggedUsername.getClub() == null){
            Club club = new Club();
            loggedUsername.setClub(club);
        }

        if(StringUtils.isBlank(loggedUsername.getClub().getAgentName())){
            loggedUsername.getClub().setAgentName("");
        }

        loggedUsername.setPassword("");

        return loggedUsername;
    }
}
