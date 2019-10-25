--drop table if exists USER_ROLES;
--drop table if exists RESTAURANT;
--drop table if exists USERS;
--drop table if exists VOTE;

create table RESTAURANT
(
    ID              INTEGER identity constraint RESTAURANT_PK
                                        primary key,
    RESTAURANT_NAME CHARACTER(200) not null,
    DATE            TIMESTAMP      not null,
    MENU            VARCHAR(255)   not null,
    constraint RESTAURANT_RESTAURANT_NAME_DATE_UINDEX
        unique (RESTAURANT_NAME, DATE)
);

create table USERS
(
    ID         INTEGER identity constraint USERS_PK
                                             primary key,
    NAME       VARCHAR(255)                     not null,
    EMAIL      VARCHAR(255)                     not null
                    constraint USERS_EMAIL_UINDEX unique,
    PASSWORD   VARCHAR(255)                     not null,
    REGISTERED TIMESTAMP default LOCALTIMESTAMP not null,
    ENABLED    BOOLEAN default TRUE             not null
);

create table USER_ROLES
(
    USER_ID INTEGER      not null
        constraint USER_ROLES_USER_ID_FK references USERS,
    ROLE    VARCHAR(255) not null,
        constraint USER_ROLES_UINDEX unique (USER_ID, ROLE)
);

create table VOTE
(
    ID            INTEGER identity constraint VOTE_PK primary key,
    RESTAURANT_ID INTEGER                          not null
                     constraint VOTE_RESTAURANT_ID_FK
                                  references RESTAURANT,
    USER_ID       INTEGER                          not null
                     constraint VOTE_USERS_ID_FK references USERS,
    DATE          TIMESTAMP default LOCALTIMESTAMP not null
);