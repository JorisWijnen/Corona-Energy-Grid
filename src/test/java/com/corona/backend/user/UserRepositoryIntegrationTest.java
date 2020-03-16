package com.corona.backend.user;

import com.corona.backend.controllers.UserController;
import com.corona.backend.models.User;
import com.corona.backend.repositories.UserRepository;
import com.corona.backend.utils.AuthenticationUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.corona.backend.security.ApplicationUserRole.USER;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import com.corona.backend.security.PasswordConfig;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    private UserRepository subject;

    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception {
        passwordEncoder = new AuthenticationUtils();
    }


    @After
    public void tearDown() throws Exception {
        subject.deleteAll();
    }

    @Test
    public void shouldSaveAndFetch() throws Exception {
        User user1 = new User("victor","victory", passwordEncoder.encode("test2123123312"),"user1@test.com", "0773077070", "0612345678", "1111TT","SCHOOLSTRAAT", "EINDHOVEN", "11","123456",true,true,true,true, USER.getGrantedAuthorities()); //default
        subject.save(user1);
        User isUser1 = subject.findUserByEmail("user1@test.com");

        assertThat(isUser1, is(user1));
    }

}
