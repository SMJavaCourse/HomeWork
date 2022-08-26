CREATE TABLE  hotels
(
    id              TEXT NOT NULL UNIQUE PRIMARY KEY,
    "name"          TEXT NOT NULL UNIQUE,
    startTime       TEXT NOT NULL
);

CREATE TABLE apartments
(
    id              TEXT NOT NULL UNIQUE PRIMARY KEY,
    hotelId         TEXT NOT NULL,
    rooms           INTEGER NOT NULL,
    numberOfRoom    INTEGER NOT NULL,
    price           INTEGER,
    capacity        INTEGER NOT NULL
);

CREATE TABLE services
(
    id              TEXT NOT NULL UNIQUE PRIMARY KEY,
    serviceName     TEXT NOT NULL,
    serviceNameRu   TEXT NOT NULL,
    defaultProperty TEXT
);

CREATE TABLE apartmentServices
(
    id              TEXT NOT NULL UNIQUE PRIMARY KEY,
    apartmentsId    TEXT NOT NULL,
    serviceId       TEXT NOT NULL,
    customProperty  TEXT
);

ALTER TABLE apartments
    ADD CONSTRAINT apartments_hotels_id_fk
        FOREIGN KEY (hotelId) REFERENCES hotels (id);

ALTER TABLE apartmentServices
    ADD CONSTRAINT apartmentServices_apartments_id_fk
        FOREIGN KEY (apartmentsId) REFERENCES apartments (id);

ALTER TABLE apartmentServices
    ADD CONSTRAINT apartmentServices_services_id_fk
        FOREIGN KEY (serviceId) REFERENCES services (id);

INSERT INTO services VALUES ('1','Balcony','балкон','');
INSERT INTO services VALUES ('2','Cleaning','уборка номера','');
INSERT INTO services VALUES ('3','Conditioner','кондиционер','');
INSERT INTO services VALUES ('4','Internet','интернет','256');
INSERT INTO services VALUES ('5','Jacuzzi','джакузи','');
INSERT INTO services VALUES ('6','Meat','шашлык','');

INSERT INTO hotels VALUES ('1','У мамы лучше','12:00');
INSERT INTO hotels VALUES ('2','Шашлычок','09:00');

INSERT INTO apartments VALUES ('1','1',1,10,1000,2);
INSERT INTO apartments VALUES ('2','1',2,20,3900,4);
INSERT INTO apartments VALUES ('3','1',2,30,3900,4);
INSERT INTO apartments VALUES ('4','1',3,40,2500,6);
INSERT INTO apartments VALUES ('5','1',3,50,3900,6);
INSERT INTO apartments VALUES ('6','2',1,11,1000,2);
INSERT INTO apartments VALUES ('7','2',2,22,2000,4);
INSERT INTO apartments VALUES ('8','2',3,33,4000,7);

INSERT INTO apartmentServices VALUES ('1','1','1','');
INSERT INTO apartmentServices VALUES ('2','2','1','');
INSERT INTO apartmentServices VALUES ('3','2','2','');
INSERT INTO apartmentServices VALUES ('4','2','3','');
INSERT INTO apartmentServices VALUES ('5','2','4','512');
INSERT INTO apartmentServices VALUES ('6','3','1','');
INSERT INTO apartmentServices VALUES ('7','3','2','');
INSERT INTO apartmentServices VALUES ('8','3','3','');
INSERT INTO apartmentServices VALUES ('9','3','4','');
INSERT INTO apartmentServices VALUES ('10','5','1','');
INSERT INTO apartmentServices VALUES ('11','5','3','');
INSERT INTO apartmentServices VALUES ('12','5','4','');
INSERT INTO apartmentServices VALUES ('13','5','5','');
INSERT INTO apartmentServices VALUES ('14','6','6','');
INSERT INTO apartmentServices VALUES ('15','7','1','');
INSERT INTO apartmentServices VALUES ('16','7','2','');
INSERT INTO apartmentServices VALUES ('17','8','2','');
INSERT INTO apartmentServices VALUES ('18','8','5','');

