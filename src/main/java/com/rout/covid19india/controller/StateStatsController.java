package com.rout.covid19india.controller;

import com.rout.covid19india.dto.StateStatsDto;
import com.rout.covid19india.service.BadRequestException;
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

    @GetMapping(value = "/states-stats/{stateCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StateStatsDto findLatestStatsByStateCode(@PathVariable("stateCode") String stateCode) {
        return stateStatsService.findLatestStatsByStateCode(stateCode);
    }

    @GetMapping(value = "/states-stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StateStatsDto> findAllStatsByStateCodeOrCountryCode(@RequestParam(value = "stateCode", required = false) String stateCode,
                                                                    @RequestParam(value = "countryCode", required = false) String countryCode) {

        if (stateCode == null && countryCode == null) {
            throw new BadRequestException("One should be present from stateCode or countryCode");
        }

        if (stateCode != null && countryCode != null) {
            throw new BadRequestException("Both stateCode and countryCode are not allowed.");
        }

        return stateStatsService.findAllStatsByStateCodeOrCountryCode(stateCode, countryCode);
    }
}
