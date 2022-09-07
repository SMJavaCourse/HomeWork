-- * table hotels * --
create table hotels
(
    id                serial
        constraint hotels_pk
            primary key,
    name              text    not null,
    apartments_id     integer not null,
    checkin_time      time    not null,
    rooms_total_count integer not null
);

create unique index hotels_id_uindex
    on hotels (id);

-- * table apartment_params * --
create table apartment_params
(
    id          serial
        constraint apartment_params_pk
            primary key,
    room_number integer          not null,
    price       double precision not null,
    places      integer          not null
);


create unique index apartment_params_id_uindex
    on apartment_params (id);

-- * table apartments * --
create table apartments
(
    id                  serial
        constraint apartments_pk
            primary key,
    apartment_name      text    not null,
    apartment_params_id integer not null
);


create unique index apartments_id_uindex
    on apartments (id);

insert into apartments (id, apartment_name, apartment_params_id)
values (2, 'Однокомнатный номер', 1);

insert into hotels (id, name, apartments_id, checkin_time, rooms_total_count)
values (1, 'Отельчик', 2, '12:00', 5);