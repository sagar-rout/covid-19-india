package com.rout.covid19india.repository;

import com.rout.covid19india.model.StateStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateStatsRepository extends JpaRepository<StateStats, UUID> {
}
