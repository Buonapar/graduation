package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.alekseiovechkin.votesystem.model.Meal;

import java.time.LocalDate;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Meal meal WHERE meal.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Meal save(Meal item);

    @EntityGraph(Meal.WITH_PARENTS)
    Meal getById(int id);

    Meal getMealById(int id);

    List<Meal> getMealsByRestaurantId(int restaurantId, Sort sort);

    List<Meal> getMealsByRestaurantIdAndDate(int restaurantId, LocalDate date);
}
}
