drop table IF EXISTS car;
drop table IF EXISTS brand;
drop table IF EXISTS users;

create table users
(
    id       SERIAL primary key,
    username varchar not null,
    password varchar not null
);

CREATE TABLE brand
(
    id     SERIAL PRIMARY KEY,
    "name" VARCHAR NOT NULL
);

CREATE TABLE car
(
    id         SERIAL PRIMARY KEY,
    brandId    integer REFERENCES brand (id),
    color      VARCHAR NOT NULL,
    createDate date    NOT NULL,
    price      integer
);

create table basket
(
    userId integer REFERENCES brand (id),
    carId  integer REFERENCES car (id)
);