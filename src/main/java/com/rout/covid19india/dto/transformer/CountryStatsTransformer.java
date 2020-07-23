package com.rout.covid19india.dto.transformer;

import com.rout.covid19india.dto.CountryStatsDto;
import com.rout.covid19india.model.CountryStats;
import org.springframework.stereotype.Component;

/**
 * Sagar Rout (sagar@rout.dev)
 */
@Component
public class CountryStatsTransformer {

    public CountryStatsDto fromDomainToDto(CountryStats domain) {
        return new CountryStatsDto().setActiveCases(domain.getActiveCases())
                .setCountryCode(domain.getCountryCode())
                .setCountryName(domain.getCountryName().getText())
                .setCuredCases(domain.getCuredCases())
                .setDeaths(domain.getDeaths())
                .setLastUpdated(domain.getLastUpdated())
                .setLastUpdatedFromSource(domain.getLastUpdatedFromSource())
                .setSamplesTestedToday(domain.getSamplesTestedToday())
                .setTotalSamplesTested(domain.getTotalSamplesTested())
                .setMigrated(domain.getMigrated());
    }
}
