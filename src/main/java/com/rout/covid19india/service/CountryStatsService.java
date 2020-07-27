package com.rout.covid19india.service;

import com.rout.covid19india.dto.CountryStatsDto;
import com.rout.covid19india.dto.transformer.CountryStatsTransformer;
import com.rout.covid19india.model.CountryStats;
import com.rout.covid19india.repository.CountryStatsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryStatsService {

    private final CountryStatsRepository countryStatsRepository;
    private final CountryStatsTransformer countryStatsTransformer;

    public CountryStatsService(
            CountryStatsRepository countryStatsRepository,
            CountryStatsTransformer countryStatsTransformer
    ) {
        this.countryStatsRepository = countryStatsRepository;
        this.countryStatsTransformer = countryStatsTransformer;
    }

    @Transactional(readOnly = true)
    public CountryStatsDto findLatestStatsByCountryCode(String countryCode) {
        final CountryStats countryStats = countryStatsRepository.findFirstByCountryCode(countryCode)
                .orElseThrow(() -> new BadRequestException(String.format("Country Code %s not supported.", countryCode)));

        return countryStatsTransformer.fromDomainToDto(countryStats);
    }

    @Transactional(readOnly = true)
    public List<CountryStatsDto> findAllStatsByCountryCode(String countryCode) {
        return countryStatsRepository.findAllByCountryCode(countryCode).stream()
                .map(countryStatsTransformer::fromDomainToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CountryStatsDto> findAllCountriesLatestStats() {
        return countryStatsRepository.findAll().stream()
                .map(this.countryStatsTransformer::fromDomainToDto)
                .collect(Collectors.toList());
    }
}
