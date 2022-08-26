CREATE TABLE cars
(
    vin   TEXT NOT NULL,
    make  TEXT NOT NULL,
    model TEXT NOT NULL,

    CONSTRAINT cars_pk_id PRIMARY KEY (vin)
);

CREATE TABLE clients
(
    id         TEXT NOT NULL,
    first_name TEXT NOT NULL,
    last_name  TEXT NOT NULL,

    CONSTRAINT clients_pk_id PRIMARY KEY (id)
);

CREATE TABLE repair_request
(
    id         TEXT NOT NULL,
    status     TEXT NOT NULL,
    client_id  TEXT NOT NULL,
    car_vin    TEXT NOT NULL,
    created_ts timestamp without time zone not null,

    CONSTRAINT repair_request_pk_id PRIMARY KEY (id)
);

ALTER TABLE repair_request
    ADD CONSTRAINT fk_repair_request_ref_clients FOREIGN KEY (client_id) REFERENCES clients;

ALTER TABLE repair_request
    ADD CONSTRAINT fk_repair_request_ref_cars FOREIGN KEY (car_vin) REFERENCES cars;

CREATE TABLE repair_request_history
(
    id                TEXT NOT NULL,
    repair_request_id TEXT NOT NULL,
    from_status       TEXT NOT NULL,
    to_status         TEXT NOT NULL,
    comment           TEXT NOT NULL,
    created_ts        timestamp without time zone not null,

    CONSTRAINT repair_request_history_pk_id PRIMARY KEY (id)
);

ALTER TABLE repair_request_history
    ADD CONSTRAINT fk_repair_request_history_ref_repair_request FOREIGN KEY (repair_request_id) REFERENCES repair_request;

insert into cars VALUES ('1FF2F2F2123324', 'vaz', '2102');