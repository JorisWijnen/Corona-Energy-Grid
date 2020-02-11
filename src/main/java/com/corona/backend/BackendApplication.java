
package com.corona.backend;

import com.corona.backend.models.Role;
import com.corona.backend.models.User;
import com.corona.backend.repositories.RoleRepository;
import com.corona.backend.repositories.UserRepository;
import com.corona.backend.utils.AuthenticationUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleRepository){
        return args -> {


            User user1 = new User("victor","victory"); //default
            User user2 = new User("Piet","Pieters"); //default

            Role adminrole = new Role();
            Role defaultrole = new Role();
            adminrole.setName("ADMIN_USER");
            defaultrole.setName("DEFAULT_USER");
            Set<Role> roles1 = new HashSet<>();
            Set<Role> roles2 = new HashSet<>();

            roles1.add(adminrole);
            roles2.add(defaultrole);

            user1.setRoles(roles1);
            user2.setRoles(roles2);

            user1.setPassword(new AuthenticationUtils().encode(user1.getPassword()));
            user2.setPassword(new AuthenticationUtils().encode(user2.getPassword()));

            roleRepository.save(adminrole);
            roleRepository.save(defaultrole);
            user1 = userRepository.save(user1);
            user2 = userRepository.save(user2);

        };
    }

}