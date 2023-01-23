--liquibase formatted sql

--changeset Ivan:1
create table users
(
    id           bigserial                not null,
    created_at   timestamp with time zone not null default current_timestamp,
    email        varchar(50),
    first_name   varchar(50),
    last_name    varchar(50),
    phone_number varchar(20),
    changed_at   timestamp with time zone not null default current_timestamp,
    primary key (id)
);