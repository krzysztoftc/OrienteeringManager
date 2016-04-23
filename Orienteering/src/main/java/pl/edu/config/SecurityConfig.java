package pl.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.edu.service.user.IUserService;
import pl.edu.model.user.Role;

/**
 * Created by bartosz on 11.04.16.
 */

@Configuration
//@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    IUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole(Role.ADMIN.getCode())
                .antMatchers("/clubs/**").hasAnyRole(Role.CLUB.getCode(),
                                                     Role.INDIVIDUAL.getCode());
//        http
//                .authorizeRequests().anyRequest().authenticated();
//        http
//                .formLogin()
//                .permitAll()
//                .failureUrl("/login?error")
//                .defaultSuccessUrl("/")
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .usernameParameter("email")
//                .and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
//                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
//        System.out.println(userService);
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
    }
}