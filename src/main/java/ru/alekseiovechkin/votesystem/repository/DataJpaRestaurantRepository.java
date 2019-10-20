package ru.alekseiovechkin.votesystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.alekseiovechkin.votesystem.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaRestaurantRepository {
    private static final Sort SORT_BY_NAME = new Sort(Sort.Direction.ASC, "name");

    @Autowired
    private CrudRestaurantRepository repository;

    public Restaurant save(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant get(int id) {
        return repository.getById(id);
    }

    public boolean delete(int id) {
        return repository.deleteDishById(id) != 0;
    }

    public List<Restaurant> getAll() {
        return repository.findAll(SORT_BY_NAME);
    }

    public List<Restaurant> getAllByDishDate(LocalDate date) {
        return repository.getAllByMenuDate(date, SORT_BY_NAME);
    }
}
