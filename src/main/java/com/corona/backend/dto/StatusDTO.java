package com.corona.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StatusDTO {

    @JsonProperty
    private Date date;

    @JsonProperty
    private int consumption;

    @JsonProperty
    private int production;

    public StatusDTO(Date date, int consumption, int production) {
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

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }
}
