DROP TABLE IF EXISTS swimming_pool;
CREATE TABLE swimming_pool(
                     pool_id BIGINT PRIMARY KEY,
                     pool_name VARCHAR(50),
                     state VARCHAR(10),
                     lot_address VARCHAR(100),
                     street_address VARCHAR(100)
);
