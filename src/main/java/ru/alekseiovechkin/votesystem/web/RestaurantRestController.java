package ru.alekseiovechkin.votesystem.web;

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
    public static final String REST_URL = "/rest/restaurant";

    private DataJpaRestaurantRepository repository;

    public RestaurantRestController(DataJpaRestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {
        return repository.get(id);
    }

    @GetMapping()
    public List<Restaurant> getAllByData(@DateTimeFormat(pattern="yyyy-MM-dd")@RequestParam LocalDate date) {
        return repository.getByDate(date);
    }

    @GetMapping("/all")
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return repository.create(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant) {
        repository.update(restaurant);
    }

}
