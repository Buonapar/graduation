insert into restaurant(
    name, date, menu)
values ('Астория', '2019-10-12', 'Рыба в кляре - 100 руб, яичница - 50 руб, чай - 30 руб, пюре - 45 руб, гречка - 75 руб');

insert into restaurant(
    name, date, menu)
values ('Макдональдс', '2019-10-12', 'гамбургер - 120 руб, салат - 55 руб, чай - 35 руб, булочка с малиной - 40 руб, наггетсы - 90 руб');

insert into users(
    name, email, password, registered, enabled)
values ('Вася', 'admin@gmail.com' , '1234', '2019-09-12', true);

insert into users(
    name, email, password, registered, enabled)
values ('Петя', 'user@gmail.com' , '1234', '2019-09-25', true);

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