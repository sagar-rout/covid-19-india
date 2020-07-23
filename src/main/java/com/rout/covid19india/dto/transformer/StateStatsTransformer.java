package com.rout.covid19india.dto.transformer;

import com.rout.covid19india.dto.StateStatsDto;
import com.rout.covid19india.model.StateStats;
import org.springframework.stereotype.Component;

/**
 * Sagar Rout (sagar@rout.dev)
 */
@Component
public class StateStatsTransformer {

    public StateStatsDto fromDomainToDto(StateStats domain){
        return new StateStatsDto().setActiveCases(domain.getActiveCases())
                .setCuredCases(domain.getCuredCases())
                .setDeaths(domain.getDeaths())
                .setLastUpdated(domain.getLastUpdated())
                .setLastUpdatedFromSource(domain.getLastUpdatedFromSource())
                .setStateCode(domain.getStateCode().name())
                .setTotalConfirmed(domain.getTotalConfirmed());
    }
}
