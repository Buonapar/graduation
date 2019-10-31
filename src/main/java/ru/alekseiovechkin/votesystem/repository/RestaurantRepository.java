package ru.alekseiovechkin.votesystem.repository;

import ru.alekseiovechkin.votesystem.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant get(int id);

    Restaurant create(Restaurant restaurant);

    void update(Restaurant restaurant);

    List<Restaurant> getAll();
}
