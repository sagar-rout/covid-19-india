package com.rout.covid19india.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Sagar Rout (sagar@rout.dev)
 * @author divya singh
 */
@Entity
public class CountryStats extends Region {

    @Id
    @GeneratedValue
    @Column(name = "country_stats_id")
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country countryName;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private int migrated;

    @Column(nullable = false)
    private int totalSamplesTested;

    @Column(nullable = false)
    private int samplesTestedToday;

    public UUID getId() {
        return id;
    }

    public CountryStats setId(UUID id) {
        this.id = id;
        return this;
    }

    public int getMigrated() {
        return migrated;
    }

    public CountryStats setMigrated(int migrated) {
        this.migrated = migrated;
        return this;
    }

    public int getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public CountryStats setTotalSamplesTested(int totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryStats setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public Country getCountryName() {
        return countryName;
    }

    public CountryStats setCountryName(Country countryName) {
        this.countryName = countryName;
        return this;
    }

    public int getSamplesTestedToday() {
        return samplesTestedToday;
    }

    public CountryStats setSamplesTestedToday(int samplesTestedToday) {
        this.samplesTestedToday = samplesTestedToday;
        return this;
    }

    @Override
    public String toString() {
        return "CountryStats{" +
                "id=" + id +
                ", countryName=" + countryName +
                ", countryCode='" + countryCode + '\'' +
                ", migrated=" + migrated +
                ", totalSamplesTested=" + totalSamplesTested +
                ", samplesTestedToday=" + samplesTestedToday +
                '}';
    }
}
