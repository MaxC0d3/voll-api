create table medico(
    id         bigint       not null auto_increment,
    name       varchar(100) not null,
    email      varchar(100) not null unique,
    document   varchar(6)   not null unique,
    specialty  varchar(160) not null,
    street     varchar(100) not null,
    state      varchar(100) not null,
    complement varchar(166),
    number     varchar(20),
    city       varchar(100) not null,
    primary key (id)
);

