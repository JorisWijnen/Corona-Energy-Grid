package com.corona.backend.services;

import com.corona.backend.dto.StatusDTO;
import com.corona.backend.models.Status;
import com.corona.backend.models.User;
import com.corona.backend.repositories.StatusRepository;
import com.corona.backend.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StatusService {

    private final StatusRepository statusRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public StatusService(StatusRepository statusRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
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

    public Set<StatusDTO> getUserStatus(Long id){
        try{
            User user = userRepository.findUserById(id);
            Set<StatusDTO> result = new HashSet<>();
            for (Status status : user.getStatus()){
                result.add(modelMapper.map(status, StatusDTO.class));
            }
            return result;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new HashSet<>();
        }
    }




}
