package com.rout.covid19india.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Sagar Rout
 * @author divya singh
 */
@Entity
public class CountryStats extends RegionBasedEntity{

    @Id
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country name;

    @Column(nullable = false)
    private int migrated;

    @Column(nullable = false)
    private int totalSamplesTested;

    @OneToMany(mappedBy = "countryStats", orphanRemoval = true, cascade = CascadeType.ALL)
    private final Set<StateStats> stateStats = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public CountryStats setId(UUID id) {
        this.id = id;
        return this;
    }

    public Country getName() {
        return name;
    }

    public CountryStats setName(Country name) {
        this.name = name;
        return this;
    }

    public Set<StateStats> getStateStats() {
        return stateStats;
    }

    public CountryStats setStateStats(Set<StateStats> stateStats) {
        this.stateStats.clear();
        this.stateStats.addAll(stateStats);
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

    @Override
    public String toString() {
        return "CountryStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", migrated=" + migrated +
                ", totalSamplesTested=" + totalSamplesTested +
                ", states=" + stateStats +
                '}';
    }
}
