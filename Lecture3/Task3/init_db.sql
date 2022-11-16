-- * table hotels * --
create table hotels
(
    id                text    not null constraint hotels_pk primary key,
    name              text    not null,
    checkin_time      time    not null
);

-- * table apartments * --
create table apartments
(
    id                  text not null constraint apartments_pk primary key,
    apartment_name      text    not null,
    hotel_id int not null
);


-- * table apartment_params * --
create table apartment_params
(
    id          text not null constraint apartment_params_pk primary key,
    room_number text          not null,
    price       double precision not null,
    places      integer          not null,
    apartment_id int not null
);


-- * table services * --
create table services
(
    id          text not null constraint services_pk primary key,
    service_name text
);

-- * table apartments_services (apartment_id <-> services_id)  * --
create table apartments_services
(
    id          text not null constraint services_pk primary key,
    apartment_id int not null,
    service_id int not null 
);

insert into services (id, list_services) values ('1', '{"balcony", "air conditioner", "internet"}');
insert into services (id, list_services) values ('2', '{"balcony", "internet"}');
insert into services (id, list_services) values ('3', '{"internet"}');

insert into apartment_params (id, room_number, price, places, services_id) values ('1', '10A', 1000, 1, '1');
insert into apartment_params (id, room_number, price, places, services_id) values ('2', '11A', 1500, 4, '2');
insert into apartment_params (id, room_number, price, places, services_id) values ('3', '12A', 1500, 2, '1');
insert into apartment_params (id, room_number, price, places, services_id) values ('4', '13B', 2500, 3, '1');


insert into apartments (id, apartment_name, apartment_params_id) values ('1', 'Однокомнатный номер', '1');
insert into apartments (id, apartment_name, apartment_params_id) values ('2', 'Двухкомнатный номер', '3');
insert into apartments (id, apartment_name, apartment_params_id) values ('3', 'Трехкомнатный номер', '4');


insert into hotels (id, name, apartments_id, checkin_time, rooms_total_count) values ('1', 'У мамы лучше', 1, '12:00', 5);
insert into hotels (id, name, apartments_id, checkin_time, rooms_total_count) values ('2', 'Шашлычок', 2, '11:00', 10);
