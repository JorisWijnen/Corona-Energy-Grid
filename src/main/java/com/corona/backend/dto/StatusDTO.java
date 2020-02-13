package com.corona.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StatusDTO {

    @JsonProperty
    private Date date;

    @JsonProperty
    private double consumption;

    @JsonProperty
    private double production;

    public StatusDTO(Date date, double consumption, double production) {
        this.date = date;
        this.consumption = consumption;
        this.production = production;
    }

    public StatusDTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getProduction() {
        return production;
    }

    public void setProduction(double production) {
        this.production = production;
    }
}
