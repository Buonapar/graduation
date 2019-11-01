package ru.alekseiovechkin.votesystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alekseiovechkin.votesystem.model.Restaurant;
import ru.alekseiovechkin.votesystem.repository.DataJpaRestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController {
    protected Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    public static final String REST_URL = "/rest/restaurant";

    private DataJpaRestaurantRepository repository;

    public RestaurantRestController(DataJpaRestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("Get restaurant {}", id);
        return repository.get(id);
    }

    @GetMapping("/byDate")
    public List<Restaurant> getAllByData(@DateTimeFormat(pattern="yyyy-MM-dd")@RequestParam LocalDate date) {
        log.info("Get all restaurants by data {}", date);
        return repository.getByDate(date);
    }

    @GetMapping("/all")
    public List<Restaurant> getAll() {
        log.info("Get all restaurants");
        return repository.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant create(@RequestBody Restaurant restaurant) {
        log.info("Created restaurant {}", restaurant);
        return repository.create(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant) {
        log.info("Update {} with id {}", restaurant, restaurant.getId());
        repository.update(restaurant);
    }

}
