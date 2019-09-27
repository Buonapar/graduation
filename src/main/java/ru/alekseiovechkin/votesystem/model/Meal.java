package ru.alekseiovechkin.votesystem.model;

import java.time.LocalDateTime;

public class Meal extends AbstractBaseEntity {
    private Restaurant restaurant;
    private int price;
    private LocalDateTime dateTime;

    public Meal() {
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
