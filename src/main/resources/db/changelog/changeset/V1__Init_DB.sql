--liquibase formatted sql

--changeset Ivan:1
create table users
(
    user_id      bigserial                not null,
    created_at   timestamp with time zone not null default current_timestamp,
    password     varchar(50),
    login        varchar(50) unique,
    email        varchar(50),
    first_name   varchar(50),
    last_name    varchar(50),
    phone_number varchar(20),
    changed_at   timestamp with time zone not null default current_timestamp,
    primary key (user_id)
);

create table address
(
    address_id bigserial not null,
    post_index bigint,
    city       varchar(50),
    country    varchar(50),
    location   varchar(100),
    primary key (address_id),
    user_id    bigserial not null
);

create table document
(
    document_id bigserial not null,
    title       varchar(50),
    content     varchar(500),
    year        integer,
    user_id     bigserial not null,
    primary key (document_id)
);

ALTER TABLE address
    ADD FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE document
    ADD FOREIGN KEY (user_id) REFERENCES users (user_id);