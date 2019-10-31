insert into restaurant(
    name, date, menu)
values ('Astoria', '2019-10-12', 'fish in batter - 100 rub, omelette - 50 rub, tea - 30 rub, puree - 45 rub, buckwheat - 75 rub');

insert into restaurant(
    name, date, menu)
values ('Bavaria', '2019-10-12', 'hamburger - 120 rub, salad - 55 rub, tea - 35 rub, raspberry bun - 40 rub, nuggets - 90 rub');

insert into users(
    name, email, password, registered, enabled)
values ('Vasya', 'admin@gmail.com' , '1234', '2019-09-12', true);

insert into users(
    name, email, password, registered, enabled)
values ('Petro', 'user@gmail.com' , '1234', '2019-09-25', true);

insert into user_roles(
    user_id, role
) VALUES (1, 'ROLE_ADMIN');

insert into user_roles(
    user_id, role
) VALUES (2, 'ROLE_USER');

insert into user_roles(
    user_id, role
) VALUES (1, 'ROLE_USER');

insert into vote(
    restaurant_id, user_id, date
) VALUES (1, 2, '2019-10-25T08:30:00');

insert into vote(
    restaurant_id, user_id, date
) VALUES (2, 1, '2019-10-24T10:30:00');