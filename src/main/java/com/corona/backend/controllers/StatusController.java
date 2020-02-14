package com.corona.backend.controllers;

import com.corona.backend.repositories.StatusRepository;
import com.corona.backend.services.StatusService;
import org.springframework.stereotype.Controller;

@Controller
public class StatusController {

    private final StatusService statusService;
    private final StatusRepository statusRepository;

    public StatusController(StatusService statusService, StatusRepository statusRepository) {
        this.statusService = statusService;
        this.statusRepository = statusRepository;
    }
}
