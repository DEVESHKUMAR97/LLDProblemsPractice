package com.deveshkumar.extraproblems.p1snackladdergame;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : Devesh Kumar
 * @project : LLDProblemsPractice
 * @date : 11-03-2023
 * @time : 05:46 pm
 */

public class Game {
    private Board board;
    private Dice dice;
    private Deque<Player> currentPlayers;

    private Deque<Player> winnerPlayers;

    public Game() {
        board = new Board(10, 20, 10);
        dice = new Dice(1);
        winnerPlayers = new LinkedList<>();
        addPlayers();
    }

    private void addPlayers() {
        currentPlayers = new LinkedList<>();
        currentPlayers.add(new Player("P1"));
        currentPlayers.add(new Player("P2"));
//        currentPlayers.add(new Player("P3"));
    }

    public void startGame() {
        while (currentPlayers.size() > 1) {
            Player player = currentPlayers.removeFirst();
            System.out.println("Before " + player.toString());

            int rolledDiceValue = dice.roleDice();
            System.out.println("Dice rolled: " + rolledDiceValue);

            int nextPosition = player.getCurrentPosition() + rolledDiceValue;
            if (nextPosition >= board.getBoardSize() * board.getBoardSize()) {
                currentPlayers.addLast(player);
                System.out.println("exceeded board range.");
                System.out.println(player.toString());
                System.out.println();
                continue;
            }

            Cell cell = board.getCell(nextPosition);
            if(cell.isContainsJump()) {
                String jumpBy = cell.getJump().getStart() < cell.getJump().getEnd() ? "Ladder" : "Snake";
                System.out.println("Jump by: " + jumpBy + " from cell " + cell.getJump().getStart()
                        + " to " + cell.getJump().getEnd());
                nextPosition = cell.getJump().getEnd();
            }

            player.setCurrentPosition(nextPosition);
            System.out.println("After " + player.toString());
            if(isWinner(player)) {
                winnerPlayers.addLast(player);
                System.out.println("Congrats for finishing.");
                System.out.println();
                continue;
            }
            currentPlayers.addLast(player);
            System.out.println();

        }
        printWinners();
    }

    private boolean isWinner(Player player) {
        return player.getCurrentPosition() == board.getBoardSize() * board.getBoardSize() - 1;
    }

    private void printWinners() {
        System.out.println("\n\nWinner List: ");
        while (winnerPlayers.size() > 0) {
            System.out.println(winnerPlayers.removeFirst().getName());
        }
    }

}
