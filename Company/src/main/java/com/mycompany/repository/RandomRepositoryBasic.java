package com.mycompany.repository;

import com.mycompany.model.Random;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public class RandomRepositoryBasic implements RandomRepository {
    private int random;
    private boolean isWinner;

    public int getRandom() {
        this.random = (int) Math.floor(Math.random() * (99) + 1);
        return this.random;
    }

    public Boolean isWinner() {
        this.random = getRandom();
        if (this.random >= 50) {
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
