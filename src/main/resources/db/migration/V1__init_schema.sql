CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE categories
(
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name           VARCHAR(100) NOT NULL UNIQUE,
    monthly_budget DECIMAL(10, 2)
);

CREATE TABLE transactions
(
    id          UUID PRIMARY KEY                  DEFAULT gen_random_uuid(),
    amount      DECIMAL(12, 2)           NOT NULL,
    type        VARCHAR(20)              NOT NULL,
    category_id UUID                     NOT NULL,

    FOREIGN KEY (category_id)
        REFERENCES categories (id),

    description VARCHAR(255),
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);