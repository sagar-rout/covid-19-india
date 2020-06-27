package com.rout.covid19india.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users") //postgres already have user table
public class User {

    @Id
    private UUID id;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String purpose;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    public UUID getId() {
        return id;
    }

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public User setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
