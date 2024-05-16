package com.example;

import java.util.*;

public class Board {
    private List<Box> aBoxes = new ArrayList<>(9);
    private GameState aGameState;
    private int[][] lines = new int[][] {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 },
            { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

    public Board() {
        aGameState = GameState.ONGOING;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                aBoxes.add(new Box(new Position(i, j)));
            }
        }
    }

    public void action(int row, int col, BoxState pBoxState) {
        Box box = this.getBox(row, col);
        box.setState(pBoxState);
    }

    public void resetBoard() {
        for (Box box : aBoxes) {
            box.empty();
        }
    }

    public boolean checkGameFinished() {
        for (int[] line : lines) {
            BoxState temp = aBoxes.get(line[0]).getState();
            boolean lineComplete = true;
            for (int index : line) {
                if (aBoxes.get(index).getState() == BoxState.EMPTY || aBoxes.get(index).getState() != temp) {
                    lineComplete = false;
                    break;
                }
            }
            if (lineComplete) {
                if (temp == BoxState.CIRCLE) {
                    aGameState = GameState.CIRCLE_WIN;
                } else {
                    aGameState = GameState.CROSS_WIN;
                }
                return true;
            }
        }

        for (Box box : aBoxes) {
            if (box.getState() == BoxState.EMPTY) {
                return false;
            }
        }

        aGameState = GameState.DRAW;
        return true;
    }

    private Box getBox(int row, int col) {
        assert row < 3 && row > 0;
        assert col < 3 && col > 0;
        for (Box box : aBoxes) {
            if (box.getPosition().getRow() == row && box.getPosition().getColumn() == col) {
                return box;
            }
        }
        return null;
    }

    public ArrayList<Box> getBoxes() {
        return (ArrayList<Box>) aBoxes;
    }

    public GameState getGameState() {
        return aGameState;
    }
}
