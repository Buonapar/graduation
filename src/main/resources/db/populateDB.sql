DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
DELETE FROM restaurants;
DELETE FROM votes;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
    ('Admin', 'admin@gmail.com', 'password'),
    ('User', 'user@gmail.com', 'admin');

INSERT INTO user_roles (user_id, role) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),

INSERT INTO meals (name, date_time, price, restaurant_id) VALUES
    ('lunch', '2019-09-30 12:00:00', 33, 100003),
    ('breakfast', '2019-09-30 10:00:00', 120, 100003),
    ('dinner', '2019-09-30 18:00:00', 100, 100003),
    ('breakfast', '2019-09-29 10:00:00', 150, 100002),
    ('dinner', '2019-09-29 18:00:00', 90, 100002),
    ('lunch', '2019-09-30 12:00:00', 50, 100004),
    ('breakfast', '2019-09-30 10:00:00', 130, 100004),

INSERT INTO restaurants (name) VALUES
    ('Restaurant1'),
    ('Restaurant2'),
    ('Restaurant3')

INSERT INTO votes (user_id, restaurant_id, date_time) VALUES
    (100000, 100003, '2019-09-29 11:30:00'),
    (100000, 100002, '2019-09-30 21:30:00'),
    (100001, 100004, '2019-09-29 15:30:00');