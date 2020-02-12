package com.corona.backend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int consumption;

    @Column(nullable = false)
    private int production;


    public Status(Date date, int consumption, int production) {
        this.date = date;
        this.consumption = consumption;
        this.production = production;
    }

    public Status() {
    }

    public Long getId() {
        return id;
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
