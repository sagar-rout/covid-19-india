package com.rout.covid19india.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Country {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", orphanRemoval = true, cascade = CascadeType.ALL)
    private final Set<State> states = new HashSet<>();

    @Column(nullable = false)
    private int activeCases;

    @Column(nullable = false)
    private int cured; // discharged

    @Column(nullable = false)
    private int deaths;

    @Column(nullable = false)
    private int migrated;

    public UUID getId() {
        return id;
    }

    public Country setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Set<State> getStates() {
        return states;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public Country setActiveCases(int activeCases) {
        this.activeCases = activeCases;
        return this;
    }

    public int getCured() {
        return cured;
    }

    public Country setCured(int cured) {
        this.cured = cured;
        return this;
    }

    public int getDeaths() {
        return deaths;
    }

    public Country setDeaths(int deaths) {
        this.deaths = deaths;
        return this;
    }

    public int getMigrated() {
        return migrated;
    }

    public Country setMigrated(int migrated) {
        this.migrated = migrated;
        return this;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
