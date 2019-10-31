package ru.alekseiovechkin.votesystem;

import ru.alekseiovechkin.votesystem.model.User;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return user.getId();
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "user=" + user +
                '}';
    }
}
