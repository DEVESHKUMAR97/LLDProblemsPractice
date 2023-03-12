package com.deveshkumar.extraproblems.p1snackladdergame;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : Devesh Kumar
 * @project : LLDProblemsPractice
 * @date : 11-03-2023
 * @time : 05:53 pm
 */
public class Dice {
    int numberOfDices;
    int diceMin = 1;
    int diceMax = 6;

    public Dice(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }

    public int roleDice() {
        int max = numberOfDices * diceMax;
        int min = numberOfDices * diceMin;
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
}
