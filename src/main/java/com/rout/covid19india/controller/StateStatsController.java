package com.rout.covid19india.controller;

import com.rout.covid19india.dto.StateStatsDto;
import com.rout.covid19india.service.StateStatsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Sagar Rout (sagar@rout.dev)
 */
@RestController
public class StateStatsController {

    private final StateStatsService stateStatsService;

    public StateStatsController(StateStatsService stateStatsService) {
        this.stateStatsService = stateStatsService;
    }

    @GetMapping(value = "/state-stats/{stateCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StateStatsDto findLatestStatsByStateCode(@PathVariable("stateCode") String stateCode) {
        return stateStatsService.findLatestStatsByStateCode(stateCode);
    }

    @GetMapping(value = "/state-stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StateStatsDto> findAllStatsByStateCode(@RequestParam("stateCode") String stateCode) {
        return stateStatsService.findAllStatsByStateCode(stateCode);
    }

    @GetMapping(value = "/state-stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StateStatsDto> findAllStatesLatestStats() {
        return stateStatsService.findAllStatesLatestStats();
    }
}
