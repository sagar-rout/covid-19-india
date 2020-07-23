package com.rout.covid19india.dto;

import java.time.LocalDateTime;

/**
 * Sagar Rout (sagar@rout.dev)
 */
public class CountryStatsDto {

    private String countryName;
    private String countryCode;
    private Integer migrated;
    private Integer totalSamplesTested;
    private Integer samplesTestedToday;
    private Integer activeCases;
    private Integer curedCases;
    private Integer deaths;
    private LocalDateTime lastUpdated;
    private LocalDateTime lastUpdatedFromSource;

    public String getCountryName() {
        return countryName;
    }

    public CountryStatsDto setCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryStatsDto setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public Integer getMigrated() {
        return migrated;
    }

    public CountryStatsDto setMigrated(Integer migrated) {
        this.migrated = migrated;
        return this;
    }

    public Integer getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public CountryStatsDto setTotalSamplesTested(Integer totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
        return this;
    }

    public Integer getSamplesTestedToday() {
        return samplesTestedToday;
    }

    public CountryStatsDto setSamplesTestedToday(Integer samplesTestedToday) {
        this.samplesTestedToday = samplesTestedToday;
        return this;
    }

    public Integer getActiveCases() {
        return activeCases;
    }

    public CountryStatsDto setActiveCases(Integer activeCases) {
        this.activeCases = activeCases;
        return this;
    }

    public Integer getCuredCases() {
        return curedCases;
    }

    public CountryStatsDto setCuredCases(Integer curedCases) {
        this.curedCases = curedCases;
        return this;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public CountryStatsDto setDeaths(Integer deaths) {
        this.deaths = deaths;
        return this;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public CountryStatsDto setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public LocalDateTime getLastUpdatedFromSource() {
        return lastUpdatedFromSource;
    }

    public CountryStatsDto setLastUpdatedFromSource(LocalDateTime lastUpdatedFromSource) {
        this.lastUpdatedFromSource = lastUpdatedFromSource;
        return this;
    }

    @Override
    public String toString() {
        return "CountryStatsDto{" +
                "countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", migrated=" + migrated +
                ", totalSamplesTested=" + totalSamplesTested +
                ", samplesTestedToday=" + samplesTestedToday +
                ", activeCases=" + activeCases +
                ", curedCases=" + curedCases +
                ", deaths=" + deaths +
                ", lastUpdated=" + lastUpdated +
                ", lastUpdatedFromSource=" + lastUpdatedFromSource +
                '}';
    }
}
