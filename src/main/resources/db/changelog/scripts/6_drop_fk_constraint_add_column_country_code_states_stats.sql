ALTER TABLE state_stats DROP CONSTRAINT state_stats_country_stats_id_fkey;

ALTER TABLE state_stats ADD COLUMN country_code text;
UPDATE state_stats SET country_code = 'IN';
ALTER TABLE state_stats ALTER country_code SET NOT NULL;

CREATE INDEX idx_state_stats_country_code ON state_stats(country_code);