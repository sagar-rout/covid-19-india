package com.rout.covid19india.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author divya singh
 */
@MappedSuperclass
public abstract class Region {

    @Column(nullable = false)
    private int activeCases;

    @Column(nullable = false)
    private int curedCases;

    @Column(nullable = false)
    private int deaths;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime lastUpdated;

    @Column(nullable = false)
    private LocalDateTime lastUpdatedFromSource;

    public int getActiveCases() {
        return activeCases;
    }

    public Region setActiveCases(int activeCases) {
        this.activeCases = activeCases;
        return this;
    }

    public int getCuredCases() {
        return curedCases;
    }

    public Region setCuredCases(int curedCases) {
        this.curedCases = curedCases;
        return this;
    }

    public int getDeaths() {
        return deaths;
    }

    public Region setDeaths(int deaths) {
        this.deaths = deaths;
        return this;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public LocalDateTime getLastUpdatedFromSource() {
        return lastUpdatedFromSource;
    }

    public Region setLastUpdatedFromSource(LocalDateTime lastUpdatedFromSource) {
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
                '}';
    }
}
