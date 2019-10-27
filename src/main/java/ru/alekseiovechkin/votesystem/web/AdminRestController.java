package ru.alekseiovechkin.votesystem.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alekseiovechkin.votesystem.model.User;
import ru.alekseiovechkin.votesystem.repository.DataJpaUserRepository;

import java.util.List;

@RestController
@RequestMapping(value = AdminRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestController {
    public static final String REST_URL = "/rest/admin/users";

    private DataJpaUserRepository repository;

    public AdminRestController(DataJpaUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return repository.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        repository.delete(id);
    }

    @GetMapping
    public List<User> getAll() {
        return repository.getAll();
    }
}
