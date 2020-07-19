package com.rout.covid19india.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Sagar Rout (sagar@rout.dev)
 * @author divya singh
 */
@Entity
public class StateStats extends Region {

    @Id
    @GeneratedValue
    @Column(name = "state_stats_id")
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State stateName;

    @Column(nullable = false)
    private int totalConfirmed;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StateCode stateCode;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_stats_id")
    private CountryStats countryStats;

    public UUID getId() {
        return id;
    }

    public StateStats setId(UUID id) {
        this.id = id;
        return this;
    }

    public CountryStats getCountryStats() {
        return countryStats;
    }

    public StateStats setCountryStats(CountryStats countryStats) {
        this.countryStats = countryStats;
        return this;
    }

    public StateCode getStateCode() {
        return stateCode;
    }

    public StateStats setStateCode(StateCode stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    public State getStateName() {
        return stateName;
    }

    public StateStats setStateName(State stateName) {
        this.stateName = stateName;
        return this;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public StateStats setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
        return this;
    }

    @Override
    public String toString() {
        return "StateStats{" +
                "id=" + id +
                ", stateName=" + stateName +
                ", totalConfirmed=" + totalConfirmed +
                ", stateCode='" + stateCode + '\'' +
                ", countryStats=" + countryStats +
                '}';
    }
}