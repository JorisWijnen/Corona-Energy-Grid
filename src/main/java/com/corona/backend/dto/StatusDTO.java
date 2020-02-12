package com.corona.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class StatusDTO {

    @JsonProperty
    private LocalDate date;

    @JsonProperty
    private int consumption;

    @JsonProperty
    private int production;

    @JsonProperty
    private String label;

    public StatusDTO(LocalDate date, int consumption, int production) {
        this.date = date;
        this.consumption = consumption;
        this.production = production;
    }

    public StatusDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void addConsumption(int addition) {
        this.consumption += addition;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public void addProduction(int addition) {
        this.production += addition;
    }
}
