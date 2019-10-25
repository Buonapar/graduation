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
            new Restaurant(REST_ID1, "Астория",
                    LocalDate.parse("2019-10-12"),
                    "Рыба в кляре - 100 руб, яичница - 50 руб, чай - 30 руб, пюре - 45 руб, гречка - 75 руб");
    public static final Restaurant restaurant2 =
            new Restaurant(null, "Пончик",
                    LocalDate.parse("2019-10-25"),
                    "пончик с рыбой - 120 руб, яичница - 50 руб, чай - 30 руб, пончик - 40 руб, пончик вяленый - 75 руб");
    public static final Restaurant restaurant3 =
            new Restaurant(REST_ID1, "Астория",
                    LocalDate.parse("2019-10-12"),
                    "Рыба в кляре - 100 руб, чай - 30 руб, пюре - 45 руб, гречка - 75 руб");
    public static final Restaurant restaurant4 =
            new Restaurant(REST_ID2, "Макдональдс",
                    LocalDate.parse("2019-10-12"),
                    "гамбургер - 120 руб, салат - 55 руб, чай - 35 руб, булочка с малиной - 40 руб, наггетсы - 90 руб");

    public static final User user_admin = new User(
            ADMIN_ID,
            "Вася",
            "admin@gmail.com" ,
            "1234",
            true,
            LocalDate.parse("2019-09-12"),
            new ArrayList<>() {{
                add(Role.ROLE_ADMIN);
                add(Role.ROLE_USER);
            }});
    public static final User user_user1 = new User(USER_ID1, "Петя", "user@gmail.com", "1234", Role.ROLE_USER);
    public static final User user_user2 = new User(null, "Федор", "fedor@mail.ru", "password", Role.ROLE_USER);

    public static final Vote vote1 = new Vote(VOTE_ID1, user_user1, restaurant1, LocalDateTime.parse("2019-10-25T08:30:00"));
    public static final Vote vote2 = new Vote(VOTE_ID2, user_admin, restaurant4, LocalDateTime.parse("2019-10-24T10:30:00"));
    public static final Vote vote3 = new Vote(null, user_user1, restaurant4, LocalDateTime.now().withNano(0));
}
