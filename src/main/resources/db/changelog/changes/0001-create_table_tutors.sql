-- liquibase formatted sql

-- changeset martins:1

CREATE TABLE tutors
(
    id      SERIAL primary key,
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL
);
