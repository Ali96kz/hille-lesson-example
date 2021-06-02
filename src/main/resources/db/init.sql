drop table IF EXISTS car;
drop table IF EXISTS brand;

CREATE TABLE brand(
     id SERIAL PRIMARY KEY,
     "name" VARCHAR NOT NULL
 );

CREATE TABLE car(
     id SERIAL PRIMARY KEY,
     brandId integer REFERENCES brand (id),
     color VARCHAR NOT NULL,
     createDate date NOT NULL,
     price integer
 );