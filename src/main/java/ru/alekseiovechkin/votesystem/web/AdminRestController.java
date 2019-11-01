package ru.alekseiovechkin.votesystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alekseiovechkin.votesystem.model.User;
import ru.alekseiovechkin.votesystem.repository.DataJpaUserRepository;

import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    protected Logger log = LoggerFactory.getLogger(AdminRestController.class);

    public static final String REST_URL = "/rest/admin/users";

    private DataJpaUserRepository repository;

    public AdminRestController(DataJpaUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        log.info("Get user {}", id);
        return repository.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("Delete user {}", id);
        repository.delete(id);
    }

    @GetMapping
    public List<User> getAll() {
        log.info("Get all users");
        return repository.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
        log.info("Created user {}", user);
        return repository.create(user);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody User user) {
        log.info("Update {} with id {}", user, user.getId());
        repository.update(user);
    }
}
