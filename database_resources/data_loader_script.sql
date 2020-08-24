CREATE DATABASE IF NOT EXISTS daimlerdb;


USE daimlerdb;


DROP TABLE IF EXISTS gps_data;

CREATE TABLE gps_data
(
    timestamp          BIGINT(20)            NOT NULL,
    line_id            INT(10),
    direction          INT(5),
    journey_pattern_id VARCHAR(20),
    time_frame         DATE,
    vehicle_journey_id INT(10),
    operator           VARCHAR(5),
    congestion         BOOLEAN,
    lon                DECIMAL(11, 8),
    lat                DECIMAL(10, 8),
    delay              INT(10),
    block_id           INT(10),
    vehicle_id         INT(10),
    stop_id            INT(10),
    at_stop            BOOLEAN,
	id                 BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY
);


LOAD DATA LOCAL INFILE '~/Desktop/Personal_Projects/Daimler_Technical_Exercise/database_resources/siri.20121123.csv' 
INTO TABLE gps_data 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
