create table if not exists restaurant_with_dish
(
    id identity not null
        constraint restaurant_with_dish_pk
            primary key,
    restaurant_name char(200) not null,
    date timestamp not null,
    menu varchar(255) not null
);

create unique index restaurant_with_dish_restaurant_name_date_uindex
    on restaurant_with_dish (restaurant_name, date);

create table if not exists vote
(
	id identity not null
		constraint vote_pk
			primary key,
	restaurant_id integer not null
		constraint VOTE_RESTAURANT_WITH_DISH_ID_FK
			references restaurant_with_dish,
	user_id integer not null
		constraint vote_users_id_fk
			references users,
	date timestamp default now() not null
);

create table if not exists users
(
	id identity not null
		constraint users_pk
			primary key,
	name varchar(255) not null,
	email varchar(255) not null,
	registered timestamp default now() not null,
	role varchar(255) not null,
	enabled boolean default true not null
);

create unique index if not exists users_email_uindex
	on users (email);

create unique index if not exists users_name_role_uindex
	on users (name, role);