package pl.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole(Role.ADMIN.getCode())
                .antMatchers("/clubs/**").hasAnyRole(Role.CLUB.getCode(),
                                                     Role.INDIVIDUAL.getCode());
        http.csrf().disable();
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
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
//        System.out.println(userService);
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    AuthenticationManager authenticationManager(){
//        AuthenticationManager authenticationManager =  new AuthenticationManager() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                return null;
//            }
//        };
//        authenticationManager.
//    }
}