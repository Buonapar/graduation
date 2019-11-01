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
