package com.rout.covid19india.service;

import com.rout.covid19india.model.*;
import com.rout.covid19india.repository.CountryStatsRepository;
import com.rout.covid19india.repository.StateStatsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

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
        countryStats.setCountryCode("IN");
        System.out.println("INDIA - IN");

        System.out.println("Active cases");
        int activeCasesCountry = convertStringToInt(document.select("div.active-case > div.iblock_text > span.icount").text());
        System.out.println(activeCasesCountry);
        countryStats.setActiveCases(activeCasesCountry);

        System.out.println("discharge");
        int dischargedCaseCountry = convertStringToInt(document.select("div.discharge > div.iblock_text > span.icount").text());
        System.out.println(dischargedCaseCountry);
        countryStats.setCuredCases(dischargedCaseCountry);

        System.out.println("death_case");
        int deathCaseCountry = convertStringToInt(document.select("div.death_case > div.iblock_text > span.icount").text());
        System.out.println(deathCaseCountry);
        countryStats.setDeaths(deathCaseCountry);

        System.out.println("migrated case");
        int migratedCaseCountry = convertStringToInt(document.select("div.migared_case > div.iblock_text > span.icount").text());
        System.out.println(migratedCaseCountry);
        countryStats.setMigrated(migratedCaseCountry);

        System.out.println("update date and time");
        String lastUpdatedDate = document.select("div.info_title > span").text().trim().substring(8);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm z (O)");
        LocalDateTime dateFromSource = LocalDateTime.parse(lastUpdatedDate, formatter);
        System.out.println(dateFromSource);
        countryStats.setLastUpdatedFromSource(dateFromSource);

        System.out.println("total samples tested till current date");
        int totalSamplesTested = convertStringToInt(document.select("div.testing_result > strong").text());
        System.out.println(totalSamplesTested);
        countryStats.setTotalSamplesTested(totalSamplesTested);

        System.out.println("samples tested today");
        int samplesTestedToday = convertStringToInt(document.select("div.testing_sample > strong").text());
        System.out.println(samplesTestedToday);
        countryStats.setSamplesTestedToday(samplesTestedToday);

        final Elements statesData = document.select("div.marquee > div.marquee_data > div.views-row");
        Set<StateStats> stateSet = new HashSet<>();

        statesData.forEach(state -> {
            StateStats stateStats = new StateStats();
            System.out.println(state.ownText());
            String name = state.select("span.st_name").text();
            State stateName = State.fromText(name).orElse(null);
            StateCode stateCode = stateName.getCode();
            System.out.println(name + " - " + stateCode);
            stateStats.setStateName(stateName);
            stateStats.setStateCode(stateCode);

            int confirmedCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-confirmed > small").text());
            System.out.println(confirmedCaseState);
            stateStats.setTotalConfirmed(confirmedCaseState);

            int activeCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-active > small").text());
            System.out.println(activeCaseState);
            stateStats.setActiveCases(activeCaseState);

            int dischargedCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-discharged > small").text());
            System.out.println(dischargedCaseState);
            stateStats.setCuredCases(dischargedCaseState);

            int deathCaseState = convertStringToInt(state.select("div.st_all_counts > div.tick-death > small").text());
            System.out.println(deathCaseState);
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
