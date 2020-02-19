package com.corona.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.corona.backend.security.ApplicationUserPermission.*;
import static com.corona.backend.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /**
         *          Try to use annotations in controllers instead of antMatchers.
         *          There is a smaller chance to make mistakes when using them(annotations).
         *
         *          When using antMatchers, go from detailed to general.
         *          They work like firewall rules where they will start at the top and go down.
         **/

        http
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
////                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*","/public/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority(USER_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST, "/user/**").hasAuthority(USER_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT, "/user/**").hasAuthority(USER_WRITE.getPermission())
//                .antMatchers("/user/**").hasAnyRole(USER.name(),ADMIN.name())
//                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("test"))
//                .roles(ADMIN.name()) //ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthority())
                .build();

         UserDetails user2 = User.builder()
                .username("user")
                .password(passwordEncoder.encode("test"))
//                .roles(USER.name()) //ROLE_USER
                 .authorities(USER.getGrantedAuthority())
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
}

