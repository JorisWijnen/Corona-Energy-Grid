package com.corona.backend.controllers;

import com.corona.backend.dto.RegisterDTO;
import com.corona.backend.dto.StatusDTO;
import com.corona.backend.models.Status;
import com.corona.backend.models.User;
import com.corona.backend.repositories.UserRepository;
import com.corona.backend.services.StatusService;
import com.corona.backend.services.UserService;
import com.corona.backend.utils.StatusPeriod;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;
    private final StatusService statusService;
    private final UserRepository userRepository;

    public UserController(UserService userService, StatusService statusService, UserRepository userRepository) {
        this.userService = userService;
        this.statusService = statusService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = RestURIConstant.newUser, method = RequestMethod.POST)
    public @ResponseBody
    User newUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    //@PreAuthorize("hasAnyAuthority('ADMIN_USER')")
    @RequestMapping(value = RestURIConstant.deleteUser, method = RequestMethod.DELETE)
    public void delete(@RequestBody User user) {
        userService.DeleteUser(user);
    }

    //@PreAuthorize("hasAnyAuthority('ADMIN_USER')")
    @RequestMapping(value = RestURIConstant.allUsers, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<User> allUsers() {
        return userService.alluser();
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(value = RestURIConstant.currentUser, method = RequestMethod.GET)
    public @ResponseBody
    User current() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String email = (String) auth.getPrincipal();
        return userRepository.findUserByEmail(email);
    }

    @RequestMapping(value = RestURIConstant.getUserStatus, method = RequestMethod.GET)
    public @ResponseBody
    List<StatusDTO> getUserStatus(@RequestParam("id") Long id) {
        User user = (User) getCurrentAuthorizedUser(User.class);
        return statusService.getStatusById(user.getId());
    }

    private Object getCurrentAuthorizedUser(Class returnType) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getCurrentUser(auth, returnType);
    }

    @RequestMapping(value = RestURIConstant.getStatus, method = RequestMethod.GET)
    public @ResponseBody
    List<StatusDTO> getStatusForPeriod(@RequestParam("id") Long id, @RequestParam("statusPeriod") StatusPeriod statusPeriod, @RequestParam("currentDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate currentDate) {
        return statusService.getStatusForPeriod(id, statusPeriod, currentDate);
    }

    @PostMapping(value = RestURIConstant.userRegistration, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String userRegister(@RequestBody String user) {
        try {
            Gson gson = new Gson();
            var userObject = gson.fromJson(user, RegisterDTO.class);

            return userService.registerUser(userObject);
        } catch (Exception e) {
            return "Failed to register: " + e.getMessage();
        }
    }
}
