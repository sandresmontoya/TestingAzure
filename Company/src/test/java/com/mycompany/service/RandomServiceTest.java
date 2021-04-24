package com.mycompany.service;

import com.mycompany.model.Random;
import com.mycompany.repository.RandomRepository;
import com.mycompany.repository.RandomRepositoryBasic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(RandomService.class)
public class RandomServiceTest {

    @SpyBean
    private RandomRepositoryBasic randomRepositoryBasic;

    @Autowired
    private RandomService randomService;

    @Test
    public void shouldBeReturnFalseWhenRandomIs1(){
        //Arrange
        when(randomRepositoryBasic.getRandom()).thenReturn(1);
        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertEquals(false,randomResult.isWinner());

    }

    @Test
    public void shouldBeReturnFalseWhenRandomIs49(){
        //Arrange
        when(randomRepositoryBasic.getRandom()).thenReturn(49);
        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertEquals(false,randomResult.isWinner());

    }

    @Test
    public void shouldBeReturnTrueWhenRandomIs51(){
        //Arrange
        when(randomRepositoryBasic.getRandom()).thenReturn(51);
        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertEquals(true, randomResult.isWinner());

    }

    @Test
    public void shouldBeReturnTrueWhenRandomIs50(){
        //Arrange
        when(randomRepositoryBasic.getRandom()).thenReturn(50);

        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertEquals(true, randomResult.isWinner());
    }

    @Test
    public void shouldBeReturnTrueWhenRandomIs99(){
        //Arrange
        when(randomRepositoryBasic.getRandom()).thenReturn(99);
        //Act
        Random randomResult = randomService.getLucky();

        //Assert
        assertEquals(true, randomResult.isWinner());
    }
}
