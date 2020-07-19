package com.rout.covid19india.repository;

import com.rout.covid19india.model.CountryStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryStatsRepository extends JpaRepository<CountryStats, UUID> {
}
