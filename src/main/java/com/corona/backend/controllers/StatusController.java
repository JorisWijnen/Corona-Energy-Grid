package com.corona.backend.controllers;

import com.corona.backend.dto.StatusDTO;
import com.corona.backend.dto.UserDTO;
import com.corona.backend.repositories.StatusRepository;
import com.corona.backend.services.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StatusController {

    private final StatusService statusService;
    private final StatusRepository statusRepository;

    public StatusController(StatusService statusService, StatusRepository statusRepository) {
        this.statusService = statusService;
        this.statusRepository = statusRepository;
    }

    @RequestMapping(value = RestURIConstant.getUserStatus, method = RequestMethod.GET)
    public @ResponseBody List<StatusDTO> getUserStatus(Long id){

        return statusService.getStatusById(id);
    }


}
