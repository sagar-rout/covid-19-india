CREATE TABLE country_stats
(
    country_stats_id uuid NOT NULL,
    country_name text NOT NULL,
    country_code text NOT NULL,
    active_cases integer NOT NULL,
    cured_cases integer NOT NULL,
    deaths integer NOT NULL,
    migrated integer NOT NULL,
    total_samples_tested integer NOT NULL,
    last_updated timestamp with time zone NOT NULL,
    last_updated_from_source timestamp with time zone NOT NULL,
    PRIMARY KEY (country_stats_id)
);

CREATE INDEX idx_country_code ON country_stats(country_code);

CREATE TABLE state_stats
(
    state_stats_id uuid NOT NULL,
    state_name text NOT NULL,
    state_code text NOT NULL,
    country_stats_id uuid REFERENCES country_stats(country_stats_id),
    active_cases integer NOT NULL,
    cured_cases integer NOT NULL,
    deaths integer NOT NULL,
    last_updated timestamp with time zone NOT NULL,
    last_updated_from_source timestamp with time zone NOT NULL,
    PRIMARY KEY (state_stats_id)
);

CREATE INDEX idx_state_code ON state_stats(state_code);