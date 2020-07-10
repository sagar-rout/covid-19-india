package com.rout.covid19india.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CovidDataLoader {

    private static final String INDIA_GOVT_COVID_URI = "https://www.mygov.in/covid-19/";

    public void loadCovidData() throws Exception {
        final Document document = Jsoup.connect(INDIA_GOVT_COVID_URI).get();

        System.out.println("Active cases");
        System.out.println(Integer.parseInt(document.select("div.active-case > div.iblock_text > span.icount").text()));

        System.out.println("discharge");
        System.out.println(Integer.parseInt(document.select("div.discharge > div.iblock_text > span.icount").text()));

        System.out.println("death_case");
        System.out.println(Integer.parseInt(document.select("div.death_case > div.iblock_text > span.icount").text()));

        System.out.println("migrated case");
        System.out.println(Integer.parseInt(document.select("div.migared_case > div.iblock_text > span.icount").text()));

        System.out.println("update date and time");
        System.out.println(document.select("div.info_title > span").text().trim().substring(7));

        System.out.println("total samples");
        System.out.println(document.select("div.testing_result > strong").text());

        System.out.println("sample positive");
        System.out.println(document.select("div.testing_sample > strong").text());

        final Elements statesData = document.select("div.marquee > div.marquee_data > div.views-row");

        for (Element state : statesData) {
            System.out.println(state.ownText());
            System.out.println(state.select("span.st_name").text());
            System.out.println(state.select("div.st_all_counts > div.tick-confirmed > small").text());
            System.out.println(state.select("div.st_all_counts > div.tick-active > small").text());
            System.out.println(state.select("div.st_all_counts > div.tick-discharged > small").text());
            System.out.println(state.select("div.st_all_counts > div.tick-death > small").text());

        }
    }
}
