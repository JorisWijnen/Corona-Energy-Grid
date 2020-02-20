package com.corona.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StatusDTO {

    @JsonProperty
    private Date date;

    @JsonProperty
    private double consumption;

    @JsonProperty
    private double production;

    @JsonProperty
    private String label;

    public StatusDTO(Date date, int consumption, int production) 
        this.date = date;
        this.consumption = consumption;
        this.production = production;
    }

    public StatusDTO() {
    }

    public StatusDTO(String label) {
        this.label = label;
    }

    @JsonIgnore
    public LocalDate getLocalDate() {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

<<<<<<< HEAD
    public double getConsumption() {
=======
    public void setLabel(String label) {
        this.label = label;
    }

    public int getConsumption() {
>>>>>>> c4971790bdc79068d493c0aae7cb131801e1f3b4
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

<<<<<<< HEAD
    public double getProduction() {
=======
    public void addConsumption(int addition) {
        this.consumption += addition;
    }

    public int getProduction() {
>>>>>>> c4971790bdc79068d493c0aae7cb131801e1f3b4
        return production;
    }

    public void setProduction(double production) {
        this.production = production;
    }

    public void addProduction(int addition) {
        this.production += addition;
    }
}
