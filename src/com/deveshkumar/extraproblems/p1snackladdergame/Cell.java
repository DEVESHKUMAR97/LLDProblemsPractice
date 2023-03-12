package com.deveshkumar.extraproblems.p1snackladdergame;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Devesh Kumar
 * @project : LLDProblemsPractice
 * @date : 11-03-2023
 * @time : 05:51 pm
 */
@Getter
@Setter
public class Cell {
    private Jump jump;

    public boolean isContainsJump() {
        return jump != null;
    }

}
