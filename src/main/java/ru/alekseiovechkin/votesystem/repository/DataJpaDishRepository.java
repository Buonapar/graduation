package ru.alekseiovechkin.votesystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alekseiovechkin.votesystem.model.Dish;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaDishRepository {
    private static final Sort SORT_BY_DATE = Sort.by(Sort.Order.desc("date"), Sort.Order.asc("name"));

    @Autowired
    private CrudDishRepository repository;

    public Dish save(Dish Dish) {
        return repository.save(Dish);
    }

    public List<Dish> save(List<Dish> Dishes) {
        return repository.saveAll(Dishes);
    }

    public Dish get(int id) {
        return repository.getDishById(id);
    }

    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    public List<Dish> getAll(int restaurantId) {
        return repository.getDishesByRestaurantId(restaurantId, SORT_BY_DATE);
    }

    public List<Dish> getAllByDate(int restaurantId, LocalDate date) {
        return repository.getDishesByRestaurantIdAndDate(restaurantId, date);
    }

    public Dish getWithRestaurant(int id) {
        return repository.getById(id);
    }
}
