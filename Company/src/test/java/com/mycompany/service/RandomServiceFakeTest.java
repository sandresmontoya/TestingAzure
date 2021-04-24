package com.mycompany.service;

import com.mycompany.model.Random;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RandomServiceFakeTest {

    @Test
    public void shouldBeReturnNumberGreaterThan100WhenGetLucky() {
        //Arrange

        RandomService randomService = new RandomService(new RandomRepositoryFake());
        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertTrue(randomResult.getRandom() >= 100);

    }
}
