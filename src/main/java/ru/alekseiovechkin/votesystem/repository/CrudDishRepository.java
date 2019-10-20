package ru.alekseiovechkin.votesystem.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.alekseiovechkin.votesystem.model.Dish;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

    @Modifying
    @Transactional
    @EntityGraph(Dish.WITH_PARENTS)
    @Query("DELETE FROM Dish meal WHERE meal.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Dish save(Dish item);

    @EntityGraph(Dish.WITH_PARENTS)
    Dish getById(int id);

    Dish getDishById(int id);

    List<Dish> getDishesByRestaurantId(int restaurantId, Sort sort);

    List<Dish> getDishesByRestaurantIdAndDate(int restaurantId, LocalDate date);
}
