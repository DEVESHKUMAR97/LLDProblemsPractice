package com.deveshkumar.extraproblems.p1snackladdergame;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Devesh Kumar
 * @project : LLDProblemsPractice
 * @date : 11-03-2023
 * @time : 06:26 pm
 */
@Getter
@Setter
public class Player {
    private String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        currentPosition = 0;
    }

    @Override
    public String toString() {
        return "Player turn : {" +
                "name='" + name + '\'' +
                ", currentPosition=" + currentPosition +
                '}';
    }
}
