package com.rout.covid19india.service;

import com.rout.covid19india.model.*;
import com.rout.covid19india.repository.CountryStatsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * Sagar Rout (sagar@rout.dev)
 */
@Component
public class CovidDataLoader {

    private static final String INDIA_GOVT_COVID_URI = "https://www.mygov.in/covid-19/";

    private final CountryStatsRepository countryStatsRepository;

    public CovidDataLoader(
            CountryStatsRepository countryStatsRepository
    ) {
        this.countryStatsRepository = countryStatsRepository;
    }

    public void loadCovidData() throws Exception {
        final Document document = Jsoup.connect(INDIA_GOVT_COVID_URI).get();

        CountryStats countryStats = new CountryStats();
        countryStats.setCountryName(Country.INDIA);
        countryStats.setCountryCode(Country.INDIA.getCode());

        int activeCasesCountry = convertStringToInt(document.select("div.active-case > div.iblock_text > span.icount").text());
        countryStats.setActiveCases(activeCasesCountry);

        int dischargedCaseCountry = convertStringToInt(document.select("div.discharge > div.iblock_text > span.icount").text());
        countryStats.setCuredCases(dischargedCaseCountry);

        int deathCaseCountry = convertStringToInt(document.select("div.death_case > div.iblock_text > span.icount").text());
        countryStats.setDeaths(deathCaseCountry);

        int migratedCaseCountry = convertStringToInt(document.select("div.migared_case > div.iblock_text > span.icount").text());
        countryStats.setMigrated(migratedCaseCountry);

        String lastUpdatedDate = document.select("div.info_title > span").text().trim().substring(8);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm z (O)");
        LocalDateTime dateFromSource = LocalDateTime.parse(lastUpdatedDate, formatter);
        countryStats.setLastUpdatedFromSource(dateFromSource);

        int totalSamplesTested = convertStringToInt(document.select("div.testing_result > strong").text());
        countryStats.setTotalSamplesTested(totalSamplesTested);

        int samplesTestedToday = convertStringToInt(document.select("div.testing_sample > strong").text());
        countryStats.setSamplesTestedToday(samplesTestedToday);

        final Elements statesData = document.select("div.marquee > div.marquee_data > div.views-row");
        Set<StateStats> stateSet = new HashSet<>();

        statesData.forEach(state -> {
            StateStats stateStats = new StateStats();
            String name = state.select("span.st_name").text();
            State stateName = State.fromText(name).orElse(null);
            StateCode stateCode = stateName.getCode();
            stateStats.setStateName(stateName);
            stateStats.setStateCode(stateCode);

            int confirmedCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-confirmed > small").text());
            stateStats.setTotalConfirmed(confirmedCaseState);

            int activeCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-active > small").text());
            stateStats.setActiveCases(activeCaseState);

            int dischargedCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-discharged > small").text());
            stateStats.setCuredCases(dischargedCaseState);

            int deathCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-death > small").text());
            stateStats.setDeaths(deathCaseState);

            stateStats.setCountryStats(countryStats);
            stateStats.setLastUpdatedFromSource(dateFromSource);
            stateSet.add(stateStats);
        });

        countryStats.setStateStats(stateSet);

        countryStatsRepository.save(countryStats);
    }

    private int convertStringToInt(String string1) {
        return Integer.parseInt(string1.replaceAll(",", ""));
    }
}
