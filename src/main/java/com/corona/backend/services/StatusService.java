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
import java.time.Month;
import java.time.format.TextStyle;
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

    public List<StatusDTO> getStatusForPeriod(Long id, StatusPeriod statusPeriod, LocalDate currentDate) {
        try {
            User user = userRepository.findUserById(id);
            Set<StatusDTO> statusSet = new HashSet<>();
            for (Status status : user.getStatus()) {
                statusSet.add(modelMapper.map(status, StatusDTO.class));
            }
            LocalDate beginDate = null;
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
            if (beginDate != null) {
                var result = sortStatusForPeriod(beginDate, currentDate, statusSet, statusPeriod);

                return result;
            }


            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    private List<StatusDTO> sortStatusForPeriod(LocalDate beginDate, LocalDate endDate, Set<StatusDTO> statuses, StatusPeriod statusPeriod) {
        List<StatusDTO> result = new ArrayList<>();
        var filtered = statuses.stream().filter((status) -> status.getLocalDate().compareTo(beginDate) >= 0 && status.getLocalDate().compareTo(endDate) <= 0).collect(Collectors.toList());
        switch (statusPeriod) {
            case YEAR:
                StatusDTO january = new StatusDTO(getMonthDisplayName(Month.JANUARY));
                StatusDTO feburary = new StatusDTO(getMonthDisplayName(Month.FEBRUARY));
                StatusDTO march = new StatusDTO(getMonthDisplayName(Month.MARCH));
                StatusDTO april = new StatusDTO(getMonthDisplayName(Month.APRIL));
                StatusDTO may = new StatusDTO(getMonthDisplayName(Month.MAY));
                StatusDTO june = new StatusDTO(getMonthDisplayName(Month.JUNE));
                StatusDTO july = new StatusDTO(getMonthDisplayName(Month.JULY));
                StatusDTO august = new StatusDTO(getMonthDisplayName(Month.AUGUST));
                StatusDTO september = new StatusDTO(getMonthDisplayName(Month.SEPTEMBER));
                StatusDTO october = new StatusDTO(getMonthDisplayName(Month.OCTOBER));
                StatusDTO november = new StatusDTO(getMonthDisplayName(Month.NOVEMBER));
                StatusDTO december = new StatusDTO(getMonthDisplayName(Month.DECEMBER));
                for (StatusDTO statusDTO : filtered) {
                    switch (statusDTO.getLocalDate().getMonthValue()) {
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
                StatusDTO currentMonth = new StatusDTO(getMonthDisplayName(LocalDate.now().getMonth()));
                StatusDTO lastMonth = new StatusDTO(getMonthDisplayName(LocalDate.now().minusMonths(1).getMonth()));
                StatusDTO lastLastMonth = new StatusDTO(getMonthDisplayName(LocalDate.now().minusMonths(2).getMonth()));
                for (StatusDTO statusDTO : filtered) {
                    var month = statusDTO.getLocalDate().getMonthValue();
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
                result.addAll(Arrays.asList(lastLastMonth, lastMonth, currentMonth));
                break;
            case MONTH:
                break;


        }
        return result;
    }

    private String getMonthDisplayName(Month month) {
        return month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

    }
}
