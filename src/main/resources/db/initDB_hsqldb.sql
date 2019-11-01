drop table USER_ROLES if exists;
drop table VOTE if exists;
drop table USERS if exists;
drop table RESTAURANT if exists;

create table RESTAURANT
(
    ID              INTEGER identity constraint RESTAURANT_PK
                                        primary key,
    NAME            CHARACTER(200) not null,
    DATE            TIMESTAMP      not null,
    MENU            VARCHAR(255)   not null,
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
        constraint USER_ROLES_USER_ID_FK references USERS ON DELETE CASCADE,
    ROLE    VARCHAR(255) not null,
);

create table VOTE
(
    ID            INTEGER identity constraint VOTE_PK primary key,
    RESTAURANT_ID INTEGER                          not null
                     constraint VOTE_RESTAURANT_ID_FK
                                  references RESTAURANT,
    USER_ID       INTEGER                          not null
                     constraint VOTE_USERS_ID_FK references USERS ON DELETE CASCADE,
    DATE          TIMESTAMP default LOCALTIMESTAMP not null
);