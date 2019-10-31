package ru.alekseiovechkin.votesystem;

import ru.alekseiovechkin.votesystem.model.Restaurant;
import ru.alekseiovechkin.votesystem.model.Role;
import ru.alekseiovechkin.votesystem.model.User;
import ru.alekseiovechkin.votesystem.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestData {
    public static final int REST_ID1 = 1;
    public static final int REST_ID2 = 2;
    public static final int REST_ID3 = 3;
    public static final int ADMIN_ID = 1;
    public static final int USER_ID1 = 2;
    public static final int USER_ID2 = 3;
    public static final int VOTE_ID1 = 1;
    public static final int VOTE_ID2 = 2;
    public static final int VOTE_ID3 = 3;
    public static final Restaurant restaurant1 =
            new Restaurant(REST_ID1, "Astoria",
                    LocalDate.parse("2019-10-12"),
                    "fish in batter - 100 rub, omelette - 50 rub, tea - 30 rub, puree - 45 rub, buckwheat - 75 rub");
    public static final Restaurant restaurant2 =
            new Restaurant(null, "Burlak",
                    LocalDate.parse("2019-10-25"),
                    "sinker with fish - 120 rub, omelette - 50 rub, tea - 30 rub, sinker - 40 rub, fillet steak - 75 rub");
    public static final Restaurant restaurant3 =
            new Restaurant(REST_ID1, "Astoria",
                    LocalDate.parse("2019-10-12"),
                    "fish in batter - 100 rub, tea - 30 rub, puree - 45 rub, buckwheat - 75 rub");
    public static final Restaurant restaurant4 =
            new Restaurant(REST_ID2, "Bavaria",
                    LocalDate.parse("2019-10-12"),
                    "hamburger - 120 rub, salad - 55 rub, tea - 35 rub, raspberry bun - 40 rub, nuggets - 90 rub");

    public static final User user_admin = new User(
            ADMIN_ID,
            "Vasya",
            "admin@gmail.com" ,
            "1234",
            true,
            LocalDate.parse("2019-09-12"),
            new ArrayList<>() {{
                add(Role.ROLE_ADMIN);
                add(Role.ROLE_USER);
            }});
    public static final User user_user1 = new User(USER_ID1, "Petro", "user@gmail.com", "1234", Role.ROLE_USER);
    public static final User user_user2 = new User(null, "Fedor", "fedor@mail.ru", "password", Role.ROLE_USER);

    public static final Vote vote1 = new Vote(VOTE_ID1, user_user1, restaurant1, LocalDateTime.parse("2019-10-25T08:30:00"));
    public static final Vote vote2 = new Vote(VOTE_ID2, user_admin, restaurant4, LocalDateTime.parse("2019-10-24T10:30:00"));
    public static final Vote vote3 = new Vote(null, user_user1, restaurant4, LocalDateTime.now().withNano(0));
}
