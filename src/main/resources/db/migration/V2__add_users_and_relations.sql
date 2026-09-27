CREATE TABLE users
(
    id            UUID PRIMARY KEY                  DEFAULT gen_random_uuid(),
    email         VARCHAR(255)             NOT NULL UNIQUE,
    password_hash VARCHAR(255)             NOT NULL,
    firstname     VARCHAR(100)             NOT NULL,
    lastname      VARCHAR(100)             NOT NULL,
    role          VARCHAR(20)              NOT NULL DEFAULT 'USER',
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

ALTER TABLE categories
    ADD COLUMN user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE transactions
    ADD COLUMN user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE;