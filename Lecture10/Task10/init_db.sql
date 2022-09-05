CREATE TABLE hotels
(
    id        TEXT PRIMARY KEY,
    name      TEXT NOT NULL UNIQUE,
    start_time TEXT NOT NULL
);

INSERT INTO hotels VALUES ('1','У мамы лучше','12:00');
INSERT INTO hotels VALUES ('2','Шашлычок','09:00');