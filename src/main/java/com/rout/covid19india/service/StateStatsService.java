package com.rout.covid19india.service;

import com.rout.covid19india.dto.StateStatsDto;
import com.rout.covid19india.dto.transformer.StateStatsTransformer;
import com.rout.covid19india.model.StateCode;
import com.rout.covid19india.model.StateStats;
import com.rout.covid19india.repository.StateStatsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateStatsService {

    private final StateStatsRepository stateStatsRepository;
    private final StateStatsTransformer stateStatsTransformer;

    public StateStatsService(StateStatsRepository stateStatsRepository, StateStatsTransformer stateStatsTransformer) {
        this.stateStatsRepository = stateStatsRepository;
        this.stateStatsTransformer = stateStatsTransformer;
    }

    @Transactional(readOnly = true)
    public StateStatsDto findLatestStatsByStateCode(String stateCode) {
        final StateStats stateStats = stateStatsRepository.findFirstByStateCode(StateCode.fromString(stateCode))
                .orElseThrow(() -> new BadRequestException(String.format("StateCode %s not supported.", stateCode)));

        return stateStatsTransformer.fromDomainToDto(stateStats);
    }

    @Transactional(readOnly = true)
    public List<StateStatsDto> findAllStatsByStateCodeOrCountryCode(String stateCode, String countryCode) {
        List<StateStats> stateStats;

        if (stateCode != null) {
            stateStats = stateStatsRepository.findAllByStateCode(StateCode.fromString(stateCode));
        } else {
            stateStats = stateStatsRepository.findAllByCountryCode(countryCode);
        }
        return stateStats.stream()
                .map(this.stateStatsTransformer::fromDomainToDto)
                .collect(Collectors.toList());
    }
}
