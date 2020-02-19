package com.corona.backend.controllers;

import com.corona.backend.models.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/public/hi", method = RequestMethod.GET)
    public @ResponseBody String PublicHi() {
    return "public hello";
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping(value = "/user/hi", method = RequestMethod.GET)
    public @ResponseBody String UserHi() {
        return "user hello";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public Integer tester(@PathVariable Integer id){
        return id * 10;
    }

    //@PreAuthorize("isAuthenticated()")
    @PreAuthorize("hasAuthority('user:write')")
    @RequestMapping(value = "/admin/hi", method = RequestMethod.GET)
    public @ResponseBody String AdminHi() {
        return "admin hello";
    }

}
