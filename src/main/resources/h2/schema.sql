DROP TABLE IF EXISTS swimming_pool;
CREATE TABLE swimming_pool
(
    poolId        BIGINT      NOT NULL AUTO_INCREMENT,
    poolName      VARCHAR(50) NOT NULL,
    poolState     VARCHAR(50) NOT NULL,
    lotAddress    VARCHAR(100),
    streetAddress VARCHAR(100),
    x             FLOAT,
    y             FLOAT,
    PRIMARY KEY (poolId)
);
