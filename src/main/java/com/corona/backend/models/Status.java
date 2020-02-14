package com.corona.backend.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate localDate;

    @Column(nullable = false)
    private double consumption;

    @Column(nullable = false)
    private double production;


    public Status(LocalDate localDate, int consumption, int production) {
        this.localDate = localDate;
        this.consumption = consumption;
        this.production = production;
    }

    public Status() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public void setDate(LocalDate localDate) {
        this.localDate = localDate;
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
