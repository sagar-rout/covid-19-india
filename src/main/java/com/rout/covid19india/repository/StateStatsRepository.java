package com.rout.covid19india.repository;

import com.rout.covid19india.model.StateStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * Sagar Rout (sagar@rout.dev)
 */
@Repository
public interface StateStatsRepository extends JpaRepository<StateStats, UUID> {

    Optional<StateStats> findFirstByStateCode(String stateCode);

    Set<StateStats> findAllByStateCode(String stateCode);

    List<StateStats> findAll();
}
