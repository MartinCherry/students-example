-- liquibase formatted sql

-- changeset martins:3


CREATE TABLE students
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL
);