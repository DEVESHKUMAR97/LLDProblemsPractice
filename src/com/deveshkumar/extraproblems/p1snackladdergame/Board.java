package com.deveshkumar.extraproblems.p1snackladdergame;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : Devesh Kumar
 * @project : LLDProblemsPractice
 * @date : 11-03-2023
 * @time : 05:53 pm
 */
@Getter
public class Board {
    private Cell[][] cells;
    private int boardSize;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        this.boardSize = boardSize;
        initializeBoard();
        addJumps(numberOfSnakes, true);
        addJumps(numberOfLadders, false);
    }

    private void initializeBoard() {
        cells = new Cell[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void addJumps(int numberOfJumps, boolean isSnakeJump) {
        while(numberOfJumps > 0) {
            int head = ThreadLocalRandom.current().nextInt(0, boardSize * boardSize - 1);
            int tail = ThreadLocalRandom.current().nextInt(0, boardSize * boardSize - 1);
            if (isSnakeJump) {
                if (head <= tail) {
                    continue;
                }
            } else {
                if (tail <= head) {
                    continue;
                }
            }
            Jump jump = new Jump(head, tail);
            if (!isValidJump(jump)) {
                continue;
            }
            Cell cell = getCell(jump.getStart());
            cell.setJump(jump);
            numberOfJumps--;
        }
    }

    private boolean isValidJump(Jump jump) {
        return !(getCell(jump.getStart()).isContainsJump()
                || getCell(jump.getEnd()).isContainsJump());
    }

    public Cell getCell(int position) {
        int col = position % boardSize;
        int row = position / boardSize;
        return cells[row][col];
    }
}
