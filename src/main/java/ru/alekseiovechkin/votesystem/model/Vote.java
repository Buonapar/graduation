package ru.alekseiovechkin.votesystem.model;

public class Vote extends AbstractBaseEntity {
    private Restaurant restaurant;
    private User user;

    public Vote() {
    }

    public Vote(Integer id, Restaurant restaurant, User user) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "restaurant=" + restaurant +
                ", user=" + user +
                '}';
    }
}
