package ru.alekseiovechkin.votesystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.alekseiovechkin.votesystem.model.Vote;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static ru.alekseiovechkin.votesystem.TestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class DataJpaVoteRepositoryTest {

    @Autowired
    DataJpaVoteRepository repository;

    @Test
    public void get() {
        Vote vote = repository.get(VOTE_ID1);
        Assert.assertEquals(vote, vote1);
    }

    @Test
    public void create() {
       repository.create(vote3);
       Assert.assertEquals(vote3, repository.get(VOTE_ID3));
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void getAll() {
        List<Vote> actual = repository.getAll();
        List<Vote> expected = Arrays.asList(vote1, vote2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() {
        Vote vote = vote1;
        vote.setRestaurant(restaurant4);
        vote.setDate(LocalDateTime.parse("2019-10-25T10:50:00"));
        repository.update(vote);
        Assert.assertEquals(vote, repository.get(VOTE_ID1));
    }
}
