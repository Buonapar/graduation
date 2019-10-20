package ru.alekseiovechkin.votesystem.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.alekseiovechkin.votesystem.AuthorizedUser;
import ru.alekseiovechkin.votesystem.View;
import ru.alekseiovechkin.votesystem.model.Vote;
import ru.alekseiovechkin.votesystem.to.VoteTo;

import java.net.URI;
import java.util.List;

import static ru.alekseiovechkin.votesystem.util.ValidationUtil.assureIdConsistent;
import static ru.alekseiovechkin.votesystem.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    public static final String REST_URL = "/vote";
    private static final Logger log = LoggerFactory.getLogger(VoteRestController.class);

    @Autowired
    private VoteService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<VoteTo> getAll(@AuthenticationPrincipal AuthorizedUser user) {
        log.info("Get all votes of user {}", user.getId());
        return modelMapper.map(service.getAll(user.getId()), VOTE_LIST_MAPPER);
    }

    @GetMapping("/{id}")
    public VoteTo get(@PathVariable int id, @AuthenticationPrincipal AuthorizedUser user) {
        log.info("Get vote {} with user {}", id, user.getId());
        Vote vote = service.get(id, user.getId());
        return modelMapper.map(vote, VoteTo.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @AuthenticationPrincipal AuthorizedUser user) {
        log.info("Delete vote {} with user {}", id, user.getId());
        service.delete(id, user.getId());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(View.Web.class) @RequestBody VoteTo voteTo, @PathVariable int id, @AuthenticationPrincipal AuthorizedUser user) {
        assureIdConsistent(voteTo, id);
        log.info("Update {} with id {} from user {}", voteTo, id, user.getUser());
        Vote update = modelMapper.map(voteTo, Vote.class);
        service.update(update, user.getId());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoteTo> createWithLocation(@Validated(View.Web.class) @RequestBody VoteTo vote) {
        VoteTo created = create(vote);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    private VoteTo create(VoteTo voteTo) {
        log.info("Create {}", voteTo);
        checkNew(voteTo);
        Vote created = service.create(modelMapper.map(voteTo, Vote.class), SecurityUtil.authUserId());
        return modelMapper.map(created, VoteTo.class);
    }
}
