package com.rout.covid19india.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * @author Sagar Rout
 */
@Entity
public class State {

    @Id
    private UUID id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @Column(nullable = false)
    private int confirmed;

    @Column(nullable = false)
    private int active;

    @Column(nullable = false)
    private int recovered;

    @Column(nullable = false)
    private int deceased;

    public UUID getId() {
        return id;
    }

    public State setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public State setName(String name) {
        this.name = name;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public State setCountry(Country country) {
        this.country = country;
        return this;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public State setConfirmed(int confirmed) {
        this.confirmed = confirmed;
        return this;
    }

    public int getActive() {
        return active;
    }

    public State setActive(int active) {
        this.active = active;
        return this;
    }

    public int getRecovered() {
        return recovered;
    }

    public State setRecovered(int recovered) {
        this.recovered = recovered;
        return this;
    }

    public int getDeceased() {
        return deceased;
    }

    public State setDeceased(int deceased) {
        this.deceased = deceased;
        return this;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", confirmed=" + confirmed +
                ", active=" + active +
                ", recovered=" + recovered +
                ", deceased=" + deceased +
                '}';
    }
}