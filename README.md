# graduation

----
Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

As a result, provide a link to github repository.

It should contain the code and **README.md with API documentation and curl commands to get data for voting and vote.**

-----------------------------

### curl samples (application deployed in application context `votesystem`).
> For windows use `Git Bash`

### get all Users
`curl -s http://localhost:8080/votesystem/rest/admin/users --user admin@gmail.com:admin`

### get Users id = 0
`curl -s http://localhost:8080/votesystem/rest/admin/users/0 --user admin@gmail.com:admin`

### delete Users id = 2
`curl -s -X DELETE http://localhost:8080/votesystem/rest/admin/users/1 --user admin@gmail.com:admin`

### create Users
`curl -s -X POST -d '{"id": null,"name": "Senya","email": "senya@gmail.com","password": "qwerty","registered": "2019-11-02","enabled": true,"roles": ["ROLE_USER"]}' -H 'Content-Type: application/json;charset=UTF-8' http://localhost:8080/votesystem/rest/admin/users --user admin@gmail.com:admin`

### update Users id = 2
`curl -s -X PUT -d '{"id": 2,"name": "Ivan","email": "ivan@gmail.com","password": "passw","registered": "2019-10-30","enabled": true,"roles": ["ROLE_USER"]}' -H 'Content-Type: application/json;charset=UTF-8' http://localhost:8080/votesystem/rest/admin/users/2 --user admin@gmail.com:admin`

### create User Body
```json
{
    "id": null,
    "name": "Senya",
    "email": "senya@gmail.com",
    "password": "qwerty",
    "registered": "2019-11-02",
    "enabled": true,
    "roles": [
        "ROLE_USER"
    ]
}
```

### update User Body
```json
{
    "id": {ID},
    "name": "Ivan",
    "email": "ivan@gmail.com",
    "password": "passw",
    "registered": "2019-10-30",
    "enabled": true,
    "roles": [
        "ROLE_USER"
    ]
}
```

### get all dish with restaurant
`curl -s http://localhost:8080/votesystem/rest/restaurant/all --user user@yandex.ru:password`

### get all dish with restaurant by date 2019-10-12
`curl -s http://localhost:8080/votesystem/rest/restaurant/byDate?date=2019-10-12 --user user@yandex.ru:password`

### create Restaurant
`curl -s -X POST -d '{"id": null,"name": "Burlak","date": "2019-11-02","menu": "hamburger - 120 rub, salad - 55 rub, tea - 35 rub, raspberry bun - 40 rub, nuggets - 90 rub"}' -H 'Content-Type: application/json;charset=UTF-8' http://localhost:8080/votesystem/rest/restaurant --user admin@gmail.com:admin`

### create Restaurant Body
```json
{
    "id": null,
    "name": "Burlak",
    "registered": "2019-11-02",
    "roles": [
        "hamburger - 120 rub, salad - 55 rub, tea - 35 rub, raspberry bun - 40 rub, nuggets - 90 rub"
    ]
}
```

### update Restaurant
`curl -s -X PUT -d '{"id": 0,"name": "Astoria","date": "2019-10-29","menu": "fish in batter - 100 rub, tea - 30 rub, puree - 45 rub, buckwheat - 75 rub"}' -H 'Content-Type: application/json;charset=UTF-8' http://localhost:8080/votesystem/rest/restaurant/0 --user admin@gmail.com:admin`

### update Restaurant Body
```json
{
    "id": 0,
    "name": "Astoria",
    "registered": "2019-10-29",
    "roles": [
        "fish in batter - 100 rub, tea - 30 rub, puree - 45 rub, buckwheat - 75 rub"
    ]
}
```

### get all Vote
`curl -s http://localhost:8080/votesystem/rest/vote/all --user admin@gmail.com:admin`

### create Vote
`curl -s -X POST -d '{"restaurantId": 0}' -H 'Content-Type: application/json;charset=UTF-8' http://localhost:8080/votesystem/rest/vote --user user@yandex.ru:password`


### update Vote
`curl -s -X PUT -d '{"id": 2,"restaurantId": 0}' -H 'Content-Type: application/json;charset=UTF-8' http://localhost:8080/votesystem/rest/vote/update --user user@yandex.ru:password`

### create Vote Body
```json
{
    "reustarantId": 1
}
```

### update Vote Body
```json
{
    "id": 0,
    "reustarantId": 1
}
```
