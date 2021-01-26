CREATE TABLE services
    (
        service_id int4 generated by default as identity,
        NAME VARCHAR(255),
        COST DECIMAL,
        CATEGORY VARCHAR(255),
        DESCRIPTION VARCHAR(255),
        PRIMARY KEY (service_id)
    );

CREATE TABLE ordered_services
    (
        service_id int4 generated by default as identity,
        NAME VARCHAR(255),
        COST DECIMAL,
        CATEGORY VARCHAR(255),
        DESCRIPTION VARCHAR(255),
        DONE BOOLEAN,
        check_id int4,
        PRIMARY KEY (service_id)
    );

CREATE TABLE checks
    (
        check_id int4 generated by default as identity,
        TOTAL_COST DECIMAL,
        PAID BOOLEAN,
        COMPLETE BOOLEAN,
        PRIMARY KEY (check_id)
    );

ALTER TABLE ordered_services
    ADD CONSTRAINT fk_check_ordered_services FOREIGN KEY (check_id) REFERENCES checks;

    CREATE TABLE coordinates
        (
            id int4 generated by default as identity,
            CITY VARCHAR(255),
            LAT DOUBLE,
            LNG DOUBLE,
            PRIMARY KEY (id)
        );