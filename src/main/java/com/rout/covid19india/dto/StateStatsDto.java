package com.rout.covid19india.dto;

import java.time.LocalDateTime;

/**
 * Sagar Rout (sagar@rout.dev)
 */
public class StateStatsDto {

    private String stateName;
    private Integer totalConfirmed;
    private String stateCode;
    private Integer activeCases;
    private Integer curedCases;
    private Integer deaths;
    private LocalDateTime lastUpdated;
    private LocalDateTime lastUpdatedFromSource;

    public String getStateName() {
        return stateName;
    }

    public StateStatsDto setStateName(String stateName) {
        this.stateName = stateName;
        return this;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public StateStatsDto setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
        return this;
    }

    public String getStateCode() {
        return stateCode;
    }

    public StateStatsDto setStateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    public Integer getActiveCases() {
        return activeCases;
    }

    public StateStatsDto setActiveCases(Integer activeCases) {
        this.activeCases = activeCases;
        return this;
    }

    public Integer getCuredCases() {
        return curedCases;
    }

    public StateStatsDto setCuredCases(Integer curedCases) {
        this.curedCases = curedCases;
        return this;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public StateStatsDto setDeaths(Integer deaths) {
        this.deaths = deaths;
        return this;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public StateStatsDto setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public LocalDateTime getLastUpdatedFromSource() {
        return lastUpdatedFromSource;
    }

    public StateStatsDto setLastUpdatedFromSource(LocalDateTime lastUpdatedFromSource) {
        this.lastUpdatedFromSource = lastUpdatedFromSource;
        return this;
    }

    @Override
    public String toString() {
        return "StateStatsDto{" +
                "stateName='" + stateName + '\'' +
                ", totalConfirmed=" + totalConfirmed +
                ", stateCode='" + stateCode + '\'' +
                ", activeCases=" + activeCases +
                ", curedCases=" + curedCases +
                ", deaths=" + deaths +
                ", lastUpdated=" + lastUpdated +
                ", lastUpdatedFromSource=" + lastUpdatedFromSource +
                '}';
    }
}
