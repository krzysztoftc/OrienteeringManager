package pl.edu.utils;

import pl.edu.model.user.Role;

/**
 * Created by bartosz on 14.05.16.
 */
public class RoleUtils {
    public static String getHomeFromRole(Role role){
        String result = null;
        if(role != null){
            switch(role){
                case ADMIN:
                    result = "redirect:/admin";
                    break;
                case CLUB:
                    result = "redirect:/clubs";
                    break;
                case INDIVIDUAL:
                    result = "redirect:/clubs";
                    break;
                default:
                    result = "index";
                    break;
            }
        }
        else {
            result = "index";
        }

        return result;
    }
}
