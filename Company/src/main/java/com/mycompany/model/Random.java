package com.mycompany.model;

public class Random {
    private int random;
    private boolean isWinner;

    public Random(int random, boolean isWinner) {
        this.random = random;
        this.isWinner = isWinner;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }
}
