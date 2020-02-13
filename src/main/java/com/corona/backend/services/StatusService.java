package com.corona.backend.services;

import com.corona.backend.dto.StatusDTO;
import com.corona.backend.models.Status;
import com.corona.backend.repositories.StatusRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class StatusService {

    private final StatusRepository statusRepository;
    private final ModelMapper modelMapper;

    public StatusService(StatusRepository statusRepository, ModelMapper modelMapper) {
        this.statusRepository = statusRepository;
        this.modelMapper = modelMapper;
    }

    public List<StatusDTO> getStatusById(Long id){
        try{
            List<Status> statuses = statusRepository.findStatusById(id);
            List<StatusDTO> result = new ArrayList<>();
            for (Status status : statuses){
                result.add(modelMapper.map(status, StatusDTO.class));
            }
            return result;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }




}
