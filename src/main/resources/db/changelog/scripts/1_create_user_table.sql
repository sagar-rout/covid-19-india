CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    user_id uuid NOT NULL,
    email_id text NOT NULL UNIQUE,
    access_token text NOT NULL,
    purpose text NOT NULL,
    created_date timestamp with time zone NOT NULL,
    last_updated timestamp with time zone NOT NULL,
    PRIMARY KEY (user_id)
);