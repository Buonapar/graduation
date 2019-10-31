package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alekseiovechkin.votesystem.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT r FROM Restaurant r WHERE r.date=date")
    List<Restaurant> getByDate(LocalDate date);
}
