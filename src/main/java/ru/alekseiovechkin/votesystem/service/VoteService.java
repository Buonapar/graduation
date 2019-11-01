package ru.alekseiovechkin.votesystem.service;

import org.springframework.stereotype.Service;
import ru.alekseiovechkin.votesystem.model.Vote;
import ru.alekseiovechkin.votesystem.repository.DataJpaRestaurantRepository;
import ru.alekseiovechkin.votesystem.repository.DataJpaUserRepository;
import ru.alekseiovechkin.votesystem.repository.DataJpaVoteRepository;
import ru.alekseiovechkin.votesystem.to.VoteTo;

import java.time.LocalTime;

@Service
public class VoteService {
    private DataJpaVoteRepository repository;
    private DataJpaUserRepository userRepository;
    private DataJpaRestaurantRepository restaurantRepository;

    public VoteService(DataJpaVoteRepository repository, DataJpaUserRepository userRepository, DataJpaRestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Vote create(VoteTo voteTo, int userId) {

        if (voteTo.isNew()) {
            Vote vote = new Vote(null,
                    userRepository.get(userId),
                    restaurantRepository.get(voteTo.getRestaurantId()));
            repository.create(vote);
            return vote;
        }
        return null;
    }

    public void update(VoteTo voteTo) {
        if (LocalTime.now().isBefore(LocalTime.of(11, 0))) {
            Vote vote = new Vote(voteTo.getId(),
                    userRepository.get(voteTo.getUserId()),
                    restaurantRepository.get(voteTo.getRestaurantId()));
            repository.update(vote);
        }
    }
}
