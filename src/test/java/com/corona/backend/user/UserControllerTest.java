package com.corona.backend.user;

import com.corona.backend.controllers.UserController;
import com.corona.backend.dto.ProfileDTO;
import com.corona.backend.dto.UserDTO;
import com.corona.backend.models.User;
import com.corona.backend.repositories.UserRepository;
import com.corona.backend.services.StatusService;
import com.corona.backend.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;
import static com.corona.backend.security.ApplicationUserRole.USER;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserControllerTest {
    private UserController subject;

    @Mock
    private UserService userService;
    @Mock
    private StatusService statusService;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        subject = new UserController(userService, statusService, userRepository);
    }

    @Test
    public void shouldReturnTest() throws Exception {
        assertThat(subject.test(), is("Test works"));
    }

    @Test
    public void shouldRegisterUser() throws Exception {

    }

    @Test
    public void shouldReturnProfile() throws Exception {
        ProfileDTO testUser  = new ProfileDTO("victor","victory","test@test.com","0773077070","0612345678","5981TT","kerkstraat","EINDHOVEN","33","123456");
        given(userService.getUserByCustomerCode("123456")).willReturn(testUser);
        ProfileDTO code = subject.getProfile("123456");
        assertThat(code.getCustomerCode(), is("123456"));

    }




}
