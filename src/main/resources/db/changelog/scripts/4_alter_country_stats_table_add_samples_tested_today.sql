-- add column samples_tested_today
ALTER table country_stats ADD COLUMN samples_tested_today int NOT NULL;

ALTER table country_stats ALTER COLUMN samples_tested_today DROP DEFAULT;