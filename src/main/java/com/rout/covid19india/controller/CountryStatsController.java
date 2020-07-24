package com.rout.covid19india.controller;

import com.rout.covid19india.dto.CountryStatsDto;
import com.rout.covid19india.service.CountryStatsService;
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
public class CountryStatsController {

    private final CountryStatsService countryStatsService;

    public CountryStatsController(CountryStatsService countryStatsService) {
        this.countryStatsService = countryStatsService;
    }

    @GetMapping(value = "/country-stats/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryStatsDto findLatestStatsByCountryCode(@PathVariable("countryCode") String countryCode) {
        return countryStatsService.findLatestStatsByCountryCode(countryCode);
    }

    @GetMapping(value = "/country-stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryStatsDto> findAllStatsByCountryCode(@RequestParam("countryCode") String countryCode) {
        return countryStatsService.findAllStatsByCountryCode(countryCode);
    }
}
