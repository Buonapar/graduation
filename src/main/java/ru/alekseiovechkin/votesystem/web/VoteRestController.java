package ru.alekseiovechkin.votesystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alekseiovechkin.votesystem.model.Vote;
import ru.alekseiovechkin.votesystem.repository.DataJpaVoteRepository;
import ru.alekseiovechkin.votesystem.service.VoteService;
import ru.alekseiovechkin.votesystem.to.VoteTo;

import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    protected Logger log = LoggerFactory.getLogger(VoteRestController.class);
    public static final String REST_URL = "/rest/vote";

    private DataJpaVoteRepository repository;
    private VoteService service;

    public VoteRestController(DataJpaVoteRepository repository, VoteService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/all")
    public List<Vote> getAll() {
        log.info("Get all votes");
        return repository.getAll();
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote create(@RequestBody VoteTo voteTo) {
        log.info("Created vote {}", voteTo);
        return service.create(voteTo, SecurityUtil.authUserId());
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody VoteTo voteTo) {
        log.info("Update {} with id {}", voteTo, voteTo.getId());
        service.update(voteTo);
    }
}
