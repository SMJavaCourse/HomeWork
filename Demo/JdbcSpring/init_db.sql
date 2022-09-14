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

CREATE TABLE car_client
(
    client_id   TEXT NOT NULL,
    car_vin  TEXT NOT NULL
);

ALTER TABLE car_client
    ADD CONSTRAINT fk_car_client_ref_clients FOREIGN KEY (client_id) REFERENCES clients;

ALTER TABLE car_client
    ADD CONSTRAINT fk_car_client_ref_cars FOREIGN KEY (car_vin) REFERENCES cars;


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

insert into clients VALUES ('14fbd742-ab98-4730-a58d-9f0ac72126bf', 'Вася', 'Пупкин');
insert into clients VALUES ('e6ca8425-6d08-4a64-b406-e46330272afb', 'Маша', 'Пупкина');

insert into car_client VALUES ('14fbd742-ab98-4730-a58d-9f0ac72126bf', '1FF2F2F2123324');
insert into car_client VALUES ('e6ca8425-6d08-4a64-b406-e46330272afb', '1FF2F2F2123324');

insert into repair_request VALUES ('38acfb91-552f-46ed-9bdd-8d70f2814db0', 'FINISHED', '14fbd742-ab98-4730-a58d-9f0ac72126bf', '1FF2F2F2123324', now());

insert into repair_request_history VALUES ('0b5c98d5-09d3-4514-943c-cfe99992dc15', '38acfb91-552f-46ed-9bdd-8d70f2814db0', 'NEW', 'ON_APPROVE', 'заявка 1', now());
insert into repair_request_history VALUES ('e8bacdc6-9031-4bfe-b478-eb05ee5f1e0c', '38acfb91-552f-46ed-9bdd-8d70f2814db0', 'ON_APPROVE', 'IN_PROGRESS', 'заявка 2', now());
insert into repair_request_history VALUES ('d2311bad-d198-4f2a-af13-73d7d976e5c6', '38acfb91-552f-46ed-9bdd-8d70f2814db0', 'IN_PROGRESS', 'FINISHED', 'заявка 3', now());