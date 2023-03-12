package com.deveshkumar.extraproblems.p1snackladdergame;

import lombok.Getter;

/**
 * @author : Devesh Kumar
 * @project : LLDProblemsPractice
 * @date : 11-03-2023
 * @time : 05:51 pm
 */

@Getter
public class Jump {
    private int start;
    private int end;

    public Jump(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
