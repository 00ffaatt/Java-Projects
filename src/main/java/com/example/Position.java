package com.example;

public class Position {
    private int aRow;
    private int aColumn;

    public Position(int pRow, int pColumn) {
        assert pRow >= 0 && pRow < 3;
        assert pColumn >= 0 && pRow < 3;

        aRow = pRow;
        aColumn = pColumn;
    }

    public int getRow() {
        return aRow;
    }

    public int getColumn() {
        return aColumn;
    }
}
