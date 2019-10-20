create table if not exists restaurant_with_dish
(
	id serial not null
		constraint restaurant_with_dish_pk
			primary key,
	restaurant_name char(200) not null,
	date timestamp not null,
	menu varchar not null
);

create unique index restaurant_with_dish_restaurant_name_date_uindex
	on restaurant_with_dish (restaurant_name, date);

alter table restaurant_with_dish owner to "user";

create table vote
(
	id serial not null
		constraint vote_pk
			primary key,
	restaurant_id integer not null
		constraint vote_restaurant_with_dish_id_fk
			references restaurant_with_dish,
	user_id integer not null
		constraint vote_users_id_fk
			references users,
	date timestamp default now() not null
);

alter table vote owner to "user";

create table if not exists users
(
	id serial not null
		constraint users_pk
			primary key,
	name varchar not null,
	email varchar not null,
	registered timestamp default now() not null,
	role varchar not null,
	enabled boolean default true not null
);

alter table users owner to "user";

create unique index if not exists users_email_uindex
	on users (email);

create unique index if not exists users_name_role_uindex
	on users (name, role);