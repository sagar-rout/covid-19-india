package com.rout.covid19india.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CovidScheduler {

    private final CovidDataLoader covidDataLoader;

    public CovidScheduler(CovidDataLoader covidDataLoader) {
        this.covidDataLoader = covidDataLoader;
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void loadLatestCovidData() throws Exception {
        covidDataLoader.loadCovidData();
    }
}
