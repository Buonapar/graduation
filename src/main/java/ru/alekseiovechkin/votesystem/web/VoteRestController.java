package ru.alekseiovechkin.votesystem.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alekseiovechkin.votesystem.model.Vote;
import ru.alekseiovechkin.votesystem.repository.DataJpaVoteRepository;
import ru.alekseiovechkin.votesystem.service.VoteService;

import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    public static final String REST_URL = "/rest/vote";

    private DataJpaVoteRepository repository;
    private VoteService service;

    public VoteRestController(DataJpaVoteRepository repository, VoteService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/all")
    public List<Vote> getAll() {
        return repository.getAll();
    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote create(@PathVariable int id) {
        return service.create(id, SecurityUtil.authUserId());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Vote vote) {
        repository.update(vote);
    }
}
