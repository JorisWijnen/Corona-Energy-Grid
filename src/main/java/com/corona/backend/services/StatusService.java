package com.corona.backend.services;

import com.corona.backend.dto.StatusDTO;
import com.corona.backend.models.Status;
import com.corona.backend.models.User;
import com.corona.backend.repositories.StatusRepository;
import com.corona.backend.repositories.UserRepository;
import com.corona.backend.utils.StatusPeriod;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<StatusDTO> getStatusById(Long id) {
        try {
            List<Status> statuses = statusRepository.findStatusById(id);
            List<StatusDTO> result = new ArrayList<>();
            for (Status status : statuses) {
                result.add(modelMapper.map(status, StatusDTO.class));
            }
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Set<StatusDTO> getStatusForPeriod(Long id, StatusPeriod statusPeriod, LocalDate currentDate) {
        try {
            User user = userRepository.findUserById(id);
            Set<StatusDTO> result = new HashSet<>();
            for (Status status : user.getStatus()) {
                result.add(modelMapper.map(status, StatusDTO.class));
            }
            LocalDate beginDate;
            switch (statusPeriod) {
                case YEAR:
                    beginDate = LocalDate.now().minusMonths(12);
                    break;
                case THREEMONTHS:
                    beginDate = LocalDate.now().minusMonths(3);
                    break;
                case MONTH:
                    beginDate = LocalDate.now().minusMonths(1);
                    break;
                case WEEK:
                    beginDate = LocalDate.now().minusWeeks(1);
                default:
                    // code block
            }


            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new HashSet<>();
        }
    }


    private List<StatusDTO> sortStatusForPeriod(LocalDate beginDate, LocalDate endDate, Set<StatusDTO> statuses, StatusPeriod statusPeriod) {
        List<StatusDTO> result = new ArrayList<>();
        var filtered = statuses.stream().filter((status) -> status.getDate().compareTo(beginDate) >= 0 && status.getDate().compareTo(endDate) <= 0).collect(Collectors.toList());
        switch (statusPeriod) {
            case YEAR:
                StatusDTO january = new StatusDTO();
                StatusDTO feburary = new StatusDTO();
                StatusDTO march = new StatusDTO();
                StatusDTO april = new StatusDTO();
                StatusDTO may = new StatusDTO();
                StatusDTO june = new StatusDTO();
                StatusDTO july = new StatusDTO();
                StatusDTO august = new StatusDTO();
                StatusDTO september = new StatusDTO();
                StatusDTO october = new StatusDTO();
                StatusDTO november = new StatusDTO();
                StatusDTO december = new StatusDTO();
                for (StatusDTO statusDTO : filtered) {
                    switch (statusDTO.getDate().getMonthValue()) {
                        case 1:
                            january.addConsumption(statusDTO.getConsumption());
                            january.addProduction(statusDTO.getProduction());
                            break;
                        case 2:
                            feburary.addConsumption(statusDTO.getConsumption());
                            feburary.addProduction(statusDTO.getProduction());
                            break;
                        case 3:
                            march.addConsumption(statusDTO.getConsumption());
                            march.addProduction(statusDTO.getProduction());
                            break;
                        case 4:
                            april.addConsumption(statusDTO.getConsumption());
                            april.addProduction(statusDTO.getProduction());
                            break;
                        case 5:
                            may.addConsumption(statusDTO.getConsumption());
                            may.addProduction(statusDTO.getProduction());
                            break;
                        case 6:
                            june.addConsumption(statusDTO.getConsumption());
                            june.addProduction(statusDTO.getProduction());
                            break;
                        case 7:
                            july.addConsumption(statusDTO.getConsumption());
                            july.addProduction(statusDTO.getProduction());
                            break;
                        case 8:
                            august.addConsumption(statusDTO.getConsumption());
                            august.addProduction(statusDTO.getProduction());
                            break;
                        case 9:
                            september.addConsumption(statusDTO.getConsumption());
                            september.addProduction(statusDTO.getProduction());
                            break;
                        case 10:
                            october.addConsumption(statusDTO.getConsumption());
                            october.addProduction(statusDTO.getProduction());
                            break;
                        case 11:
                            november.addConsumption(statusDTO.getConsumption());
                            november.addProduction(statusDTO.getProduction());
                            break;
                        case 12:
                            december.addConsumption(statusDTO.getConsumption());
                            december.addProduction(statusDTO.getProduction());
                            break;
                    }
                }
                result.addAll(Arrays.asList(january, feburary, march, april, may, june, july, august, september, october, november, december));
                break;
            case THREEMONTHS:
                StatusDTO currentMonth = new StatusDTO();
                StatusDTO lastMonth = new StatusDTO();
                StatusDTO lastLastMonth = new StatusDTO();
                for (StatusDTO statusDTO : filtered) {
                    var month = statusDTO.getDate().getMonthValue();
                    if (month == LocalDate.now().getMonthValue()) {
                        currentMonth.addProduction(statusDTO.getProduction());
                        currentMonth.addConsumption(statusDTO.getConsumption());
                    } else if (month == LocalDate.now().getMonthValue() - 1) {
                        lastMonth.addProduction(statusDTO.getProduction());
                        lastMonth.addConsumption(statusDTO.getConsumption());
                    } else if (month == LocalDate.now().getMonthValue() - 2) {
                        lastLastMonth.addProduction(statusDTO.getProduction());
                        lastLastMonth.addConsumption(statusDTO.getConsumption());
                    }
                }
                result.addAll(Arrays.asList(currentMonth, lastLastMonth, lastMonth));
                break;

        }
        return null;
    }
}
