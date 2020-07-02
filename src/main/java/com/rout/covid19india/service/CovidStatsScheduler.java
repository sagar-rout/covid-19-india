package com.rout.covid19india.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Sagar Rout
 */
@Component
public class CovidStatsScheduler {

    private static final Logger log = LoggerFactory.getLogger(CovidStatsScheduler.class);

    @Scheduled(cron = "*/5 * * * * *")
    public void currentTime() {
        log.info("Current Time      = {}", new Date());
    }
}
