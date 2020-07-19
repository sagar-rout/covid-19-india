-- add column total_confirmed
ALTER table state_stats ADD COLUMN total_confirmed int NOT NULL;

ALTER table state_stats ALTER COLUMN total_confirmed DROP DEFAULT;