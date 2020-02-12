
package com.corona.backend;

import com.corona.backend.models.Role;
import com.corona.backend.models.Status;
import com.corona.backend.models.User;
import com.corona.backend.repositories.RoleRepository;
import com.corona.backend.repositories.StatusRepository;
import com.corona.backend.repositories.UserRepository;
import com.corona.backend.utils.AuthenticationUtils;
import com.corona.backend.utils.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleRepository, StatusRepository statusRepository){
        return args -> {

            RandomString rdm = new RandomString();
            System.out.println(rdm.getAlphaNumericString(8));
            User user1 = new User("victor","victory","fontys123","test@test.com","5981KK", "dorpsstraat", "PANNINGEN", "12a",rdm.getAlphaNumericString(8)); //default
            User user2 = new User("Piet","Pieters","fobba123","test@test.nl","5981CC","kerkstraat", "WEERT", "13", rdm.getAlphaNumericString(8)); //default

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


            Status status1 = new Status();
            Status status2 = new Status();
            Status status3 = new Status();


            status1.setDate(new Date());
            status1.setConsumption(100);
            status1.setProduction(66);

            status2.setDate(new Date());
            status2.setConsumption(100);
            status2.setProduction(122);

            status3.setDate(new Date());
            status3.setConsumption(111);
            status3.setProduction(133);

            Set<Status> status_dashboard1 = new HashSet<>();
            Set<Status> status_dashboard2 = new HashSet<>();

            status_dashboard1.add(status1);
            status_dashboard2.add(status2);
            status_dashboard2.add(status3);


            user1.setStatus(status_dashboard1);
            user2.setStatus(status_dashboard2);

            statusRepository.save(status1);
            statusRepository.save(status2);
            statusRepository.save(status3);

            user1 = userRepository.save(user1);
            user2 = userRepository.save(user2);









        };
    }

}