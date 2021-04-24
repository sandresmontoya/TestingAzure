package com.mycompany.service;

import com.mycompany.model.Random;
import com.mycompany.repository.RandomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@WebMvcTest(RandomRepository.class)
public class RandomServiceFakeTest {

    @Test
    public void shouldBeReturnNumberGreaterThan100WhenGetLucky() {
        //Arrange
        RandomRepository randomRepository = new RandomRepositoryFake();
        RandomService randomService = new RandomService(randomRepository);

        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertTrue(randomResult.getRandom() >= 100);

    }
}
