package com.mycompany.service;

import com.mycompany.model.Random;
import com.mycompany.repository.RandomRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


public class RandomRepositoryFake implements RandomRepository {
    private int random;
    private boolean isWinner;

    public int getRandom() {
        this.random = (int) Math.floor(Math.random() * (1000) + 100);
        return this.random;
    }

    public Boolean isWinner() {
        this.random = getRandom();
        if (this.random >= 500) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Random getLucky() {
        this.isWinner = isWinner();
        return new Random(this.random, this.isWinner);
    }
}
