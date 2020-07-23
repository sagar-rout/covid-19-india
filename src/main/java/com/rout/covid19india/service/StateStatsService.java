package com.rout.covid19india.service;

import com.rout.covid19india.dto.StateStatsDto;
import com.rout.covid19india.dto.transformer.StateStatsTransformer;
import com.rout.covid19india.model.StateStats;
import com.rout.covid19india.repository.StateStatsRepository;
import org.springframework.stereotype.Service;

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

    public StateStatsDto findLatestStatsByStateCode(String stateCode) {
        final StateStats stateStats = stateStatsRepository.findFirstByStateCode(stateCode)
                .orElseThrow(() -> new NoDataFoundException(String.format("StateStats are missing for this %s stateCode", stateCode)));

        return stateStatsTransformer.fromDomainToDto(stateStats);
    }

    public List<StateStatsDto> findAllStatsByStateCode(String stateCode) {
        return stateStatsRepository.findAllByStateCode(stateCode).stream()
                .map(this.stateStatsTransformer::fromDomainToDto)
                .collect(Collectors.toList());
    }

    public List<StateStatsDto> findAllStatesLatestStats() {
        return stateStatsRepository.findAll()
                .stream()
                .map(this.stateStatsTransformer::fromDomainToDto)
                .collect(Collectors.toList());
    }
}
