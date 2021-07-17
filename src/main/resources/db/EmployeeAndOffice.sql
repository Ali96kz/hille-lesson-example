create table if not exists office
(
    id      bigserial primary key,
    address varchar
);

create table if not exists employee
(
    id         bigserial primary key,
    first_name varchar,
    last_name  varchar,
    age        int,
    income     int,
    office_id  int8 references office (id)
);
