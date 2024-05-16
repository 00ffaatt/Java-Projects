package com.example;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    @Test
    public void testCircleWin1() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CIRCLE);
        boxes.get(1).setState(BoxState.CIRCLE);
        boxes.get(2).setState(BoxState.CIRCLE);
        boxes.get(3).setState(BoxState.CROSS);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.CIRCLE_WIN, true);
    }

    @Test
    public void testCircleWin2() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CIRCLE);
        boxes.get(3).setState(BoxState.CIRCLE);
        boxes.get(6).setState(BoxState.CIRCLE);
        boxes.get(4).setState(BoxState.CROSS);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.CIRCLE_WIN, true);
    }

    @Test
    public void testCircleWin3() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CIRCLE);
        boxes.get(4).setState(BoxState.CIRCLE);
        boxes.get(8).setState(BoxState.CIRCLE);
        boxes.get(3).setState(BoxState.CROSS);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.CIRCLE_WIN, true);
    }

    @Test
    public void testCrossWin1() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CROSS);
        boxes.get(1).setState(BoxState.CROSS);
        boxes.get(2).setState(BoxState.CROSS);
        boxes.get(3).setState(BoxState.CIRCLE);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.CROSS_WIN, true);
    }

    @Test
    public void testCrossWin2() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CROSS);
        boxes.get(3).setState(BoxState.CROSS);
        boxes.get(6).setState(BoxState.CROSS);
        boxes.get(4).setState(BoxState.CIRCLE);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.CROSS_WIN, true);
    }

    @Test
    public void testCrossWin3() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CROSS);
        boxes.get(4).setState(BoxState.CROSS);
        boxes.get(8).setState(BoxState.CROSS);
        boxes.get(3).setState(BoxState.CIRCLE);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.CROSS_WIN, true);
    }

    @Test
    public void testOngoing() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CROSS);
        boxes.get(1).setState(BoxState.CIRCLE);
        boxes.get(2).setState(BoxState.CROSS);
        boxes.get(3).setState(BoxState.CIRCLE);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(!gameFinished && circleWinBoard.getGameState() == GameState.ONGOING, true);
    }

    @Test
    public void testDraw() {
        Board circleWinBoard = new Board();
        ArrayList<Box> boxes = circleWinBoard.getBoxes();
        boxes.get(0).setState(BoxState.CROSS);
        boxes.get(1).setState(BoxState.CIRCLE);
        boxes.get(2).setState(BoxState.CIRCLE);
        boxes.get(3).setState(BoxState.CIRCLE);
        boxes.get(4).setState(BoxState.CROSS);
        boxes.get(5).setState(BoxState.CROSS);
        boxes.get(6).setState(BoxState.CIRCLE);
        boxes.get(7).setState(BoxState.CROSS);
        boxes.get(8).setState(BoxState.CIRCLE);
        boolean gameFinished = circleWinBoard.checkGameFinished();
        assertEquals(gameFinished && circleWinBoard.getGameState() == GameState.DRAW, true);
    }
}
