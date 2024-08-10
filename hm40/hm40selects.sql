create table courses
(
    id   serial      not null
        constraint corses_pk
            primary key,
    name varchar(20) not null
);
create table public.student
(
    id               serial      not null
        constraint student_pk
            primary key,
    name             varchar(20) not null,
    start_studing    timestamp   not null,
    finished_studing timestamp   not null
);

create table public.teachers
(
    id   serial      not null
        constraint teachers_pk
            primary key,
    name varchar(20) not null
);
create table "group"
(
    id          serial
        constraint group_pk
            primary key,
    name        varchar(20) not null,
    start_date  timestamp   not null,
    finish_date timestamp   not null,
    course_id   serial
        constraint group_courses_id_fk
            references courses,
    teacher_id  serial
        constraint group_teachers_id_fk
            references teachers,
    student_id  serial
        constraint group___fk
            references student
);
--task1
select courses.name , count(teachers.id) from courses
join teachers on teachers.id =  courses.id
group by courses.name, teachers.id ;

--task2
select courses.name, count("group".id), "group".name from "group"
join courses  on "group".course_id = courses.id
  join student on "group".student_id = student.id
 where "group".finish_date < '2024-11-17'
group by courses.name, "group".name
order by "group".name;

--task3

select COUNT(student.id) AS количество,courses.name AS курс
from courses
join "group" ON courses.id = "group".course_id
join student ON "group".student_id = student.id
where "group".start_date > '2023-07-13 '
group by courses.name
order by courses.name;

--task4
    select COUNT(student.id) AS количество,"group".name AS группа
from "group"
join student ON "group".student_id = student.id
where "group".start_date > '2023-09-18'
group by "group".name
    order by "group".name;


--task5
    select COUNT(student.id) AS количество,"group".name AS группа
from "group"
join student ON "group".student_id = student.id
where "group".start_date < '2024-01-13'
group by "group".name
    order by COUNT(student.id) desc ;



--task6
select teachers.name from courses
join public.teachers  on courses.teachers_id = teachers.id
where courses.id != 2;

--task7
select COUNT(student.id) AS количество,"group".name AS группа
from "group"
join student ON "group".student_id = student.id
where "group".finish_date > student.start_studing
and "group".finish_date >= student.finished_studing
group by "group".name
    order by COUNT(student.id) desc ;
--task10
select count(student.id) as количество,"group".name, courses.name AS группа
from "group"
join student ON "group".student_id = student.id
join courses  on courses.id = "group".course_id
where "group".finish_date <= current_date
    and student.finished_studing <  "group".finish_date
group by "group".name, courses.name
order by количество desc ;