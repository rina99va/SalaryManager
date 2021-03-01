drop table if exists unit cascade;
create table unit
(
    id        varchar(255) not null,
    name      varchar(255),
    title     varchar(255),
    primary key (id),
    timestamp varchar(255),
    salary integer
);