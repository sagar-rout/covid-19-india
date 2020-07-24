package com.rout.covid19india.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CovidScheduler {

    private final CovidDataLoader covidDataLoader;

    public CovidScheduler(CovidDataLoader covidDataLoader) {
        this.covidDataLoader = covidDataLoader;
    }

    @Scheduled(cron = "0 0 5,17 * * ?", zone = "Asia/Kolkata") // twice a day at 5 AM and 5 PM
    public void loadLatestCovidData() throws Exception {
        covidDataLoader.loadCovidData();
    }
}
