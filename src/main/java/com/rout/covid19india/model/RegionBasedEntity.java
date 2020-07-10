package com.rout.covid19india.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author divya singh
 */
@MappedSuperclass
public abstract class RegionBasedEntity {

    @Column(nullable = false)
    private int activeCases;

    @Column(nullable = false)
    private int curedCases;

    @Column(nullable = false)
    private int deaths;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    @Column(nullable = false)
    private LocalDateTime lastUpdatedFromSource;

    public int getActiveCases() {
        return activeCases;
    }

    public RegionBasedEntity setActiveCases(int activeCases) {
        this.activeCases = activeCases;
        return this;
    }

    public int getCuredCases() {
        return curedCases;
    }

    public RegionBasedEntity setCuredCases(int curedCases) {
        this.curedCases = curedCases;
        return this;
    }

    public int getDeaths() {
        return deaths;
    }

    public RegionBasedEntity setDeaths(int deaths) {
        this.deaths = deaths;
        return this;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public RegionBasedEntity setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public LocalDateTime getLastUpdatedFromSource() {
        return lastUpdatedFromSource;
    }

    public RegionBasedEntity setLastUpdatedFromSource(LocalDateTime lastUpdatedFromSource) {
        this.lastUpdatedFromSource = lastUpdatedFromSource;
        return this;
    }

    @Override
    public String toString() {
        return "RegionBaseEntity{" +
                "activeCases=" + activeCases +
                ", curedCases=" + curedCases +
                ", deaths=" + deaths +
                ", lastUpdated=" + lastUpdated +
                ", lastUpdatedFromSource=" + lastUpdatedFromSource +
                '}';
    }
}
