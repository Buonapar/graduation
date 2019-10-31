package ru.alekseiovechkin.votesystem.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.alekseiovechkin.votesystem.model.Restaurant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static ru.alekseiovechkin.votesystem.TestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class DataJpaRestaurantRepositoryTest {

    @Autowired
    private DataJpaRestaurantRepository repository;

    @Test
    public void get() {
        Restaurant restaurant = repository.get(REST_ID1);
        Assert.assertEquals(restaurant1, restaurant);
    }

    @Test
    public void save() {
        repository.create(restaurant2);
        Assert.assertEquals(restaurant2, repository.get(REST_ID3));
    }

    @Test
    public void update() {
        repository.update(restaurant3);
        Assert.assertEquals(restaurant3, repository.get(REST_ID1));
    }

    @Test
    public void getAll() {
        List<Restaurant> actual = repository.getAll();
        List<Restaurant> expected = Arrays.asList(restaurant1, restaurant4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getByDate() {
        List<Restaurant> restaurants = repository.getByDate(LocalDate.parse("2019-10-12"));
    }
}