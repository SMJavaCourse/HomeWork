CREATE TABLE countries
(
    id   TEXT PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE regions
(
    id         TEXT PRIMARY KEY,
    name       TEXT NOT NULL,
    country_id TEXT NOT NULL REFERENCES countries (id)
);

CREATE TABLE cities
(
    id        TEXT PRIMARY KEY,
    name      TEXT NOT NULL,
    region_id TEXT NOT NULL REFERENCES regions (id)
);


insert into countries VALUES ('RU','Россия');
insert into regions VALUES ('78','Санкт-Петербург','RU');
insert into cities VALUES ('1','Санкт-Петербург','78');