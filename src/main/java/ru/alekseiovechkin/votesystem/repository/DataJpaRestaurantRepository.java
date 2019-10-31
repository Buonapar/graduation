package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.alekseiovechkin.votesystem.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {
    private static final Sort SORT_DATE_NAME = new Sort(Sort.Direction.ASC, "date", "name");

    private final CrudRestaurantRepository repository;

    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRestaurantRepository) {
        this.repository = crudRestaurantRepository;
    }

    @Override
    public Restaurant get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll(SORT_DATE_NAME);
    }

    public List<Restaurant> getByDate(LocalDate date) {
        return repository.getByDate(date);
    }
}
