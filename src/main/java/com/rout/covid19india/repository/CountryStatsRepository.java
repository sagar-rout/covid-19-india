package com.rout.covid19india.repository;

import com.rout.covid19india.model.CountryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Sagar Rout (sagar@rout.dev)
 */
@Repository
public interface CountryStatsRepository extends JpaRepository<CountryStats, UUID> {

    Optional<CountryStats> findFirstByCountryCode(String countryCode);

    Set<CountryStats> findAllByCountryCode(String countryCode);

    @Query("select c from CountryStats c ")
    @Modifying
    List<CountryStats> findAllByLastUpdated();
}
