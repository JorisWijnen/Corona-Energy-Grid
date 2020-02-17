package com.corona.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


//todo remove me in implementation
@Controller
public class AuthTestingController {
    @RequestMapping(value = "/public/hello", method = RequestMethod.GET)
    public @ResponseBody
    String publichello(){
        return "Hello world";
    }

    @RequestMapping(value = "/user/hello", method = RequestMethod.GET)
    public @ResponseBody
    String userhello(Principal principal){
        return "Hello user" + principal.getName();
    }

    @RequestMapping(value = "/admin/hello", method = RequestMethod.GET)
    public @ResponseBody
    String securehello(){
        return "Hello world, this is a secure message";
    }
}
