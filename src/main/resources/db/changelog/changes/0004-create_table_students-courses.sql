-- liquibase formatted sql

-- changeset martins:4


CREATE TABLE students_courses
(
    student_id int,
    course_id  int,

    constraint student_id_fkey foreign key (student_id) references students (id),
    constraint course_id_fkey foreign key (course_id) references courses (id)

);