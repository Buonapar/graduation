insert into restaurant_with_dish(
	restaurant_name, date, menu)
values ('Астория', '2019-10-12', 'Рыба в кляре - 100 руб, яичница - 50 руб, чай - 30 руб, пюре - 45 руб, гречка - 75 руб');

insert into restaurant_with_dish(
	restaurant_name, date, menu)
values ('Макдональдс', '2019-10-12', 'гамбургер - 120 руб, салат - 55 руб, чай - 35 руб, булочка с малиной - 40 руб, наггетсы - 90 руб');


DELETE FROM restaurant_with_dish r
WHERE r.restaurant_name='Астория';

insert into users(
	name, email, registered, role, enabled)
values ('Вася', 'admin@gmail.com' , '2019-09-12', 'ADMIN', true);

insert into users(
	name, email, registered, role, enabled)
values ('Петя', 'user@gmail.com' , '2019-09-25', 'USER', true);

insert into vote(
    restaurant_id, user_id
) VALUES (1, 2);

insert into vote(
	restaurant_id, user_id
) VALUES (3, 1);

SELECT rwd.restaurant_name
from vote as v
join restaurant_with_dish rwd on v.restaurant_id = rwd.id
where v.user_id=1;