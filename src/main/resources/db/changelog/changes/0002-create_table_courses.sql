-- liquibase formatted sql

-- changeset martins:2

CREATE TABLE courses
(
    id       serial primary key,
    name     VARCHAR(255) Not null,
    tutor_id int          NOT NULL,
    constraint tutor_id_fkey foreign key (tutor_id) references tutors (id)
);