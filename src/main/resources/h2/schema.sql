DROP TABLE IF EXISTS swimming_pool;
CREATE TABLE swimming_pool
(
    pool_id        BIGINT      NOT NULL AUTO_INCREMENT,
    pool_name      VARCHAR(50) NOT NULL,
    state          VARCHAR(10) NOT NULL,
    lot_address    VARCHAR(100),
    street_address VARCHAR(100),
    PRIMARY KEY (pool_id)
);
