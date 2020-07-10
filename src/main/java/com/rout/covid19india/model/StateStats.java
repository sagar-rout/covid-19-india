package com.rout.covid19india.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Sagar Rout
 * @author divya singh
 */
@Entity
public class StateStats extends RegionBasedEntity {

    @Id
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private State name;

    @ManyToOne(fetch = FetchType.LAZY)
    private CountryStats countryStats;

    public UUID getId() {
        return id;
    }

    public StateStats setId(UUID id) {
        this.id = id;
        return this;
    }

    public State getName() {
        return name;
    }

    public StateStats setName(State name) {
        this.name = name;
        return this;
    }

    public CountryStats getCountryStats() {
        return countryStats;
    }

    public StateStats setCountryStats(CountryStats countryStats) {
        this.countryStats = countryStats;
        return this;
    }

    @Override
    public String toString() {
        return "StateStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + countryStats +
                '}';
    }
}