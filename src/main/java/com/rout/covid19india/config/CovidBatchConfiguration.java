package com.rout.covid19india.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class CovidBatchConfiguration {


    @Bean
    public Job downloadCovidStatsJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        jobBuilderFactory.get("downloadCovidStatsJob")
        .start();
    }


    @Bean
    public Step downloadCovidStatsStep(StepBuilderFactory stepBuilderFactory){
        return stepBuilderFactory.get("downloadCovidStatsStep")
                .chunk(1)
                .reader()
                .processor()
                .writer()
                .build();

    }

    @Bean
    public
}
