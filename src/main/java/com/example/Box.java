package com.example;

public class Box {
    private BoxState aBoxState;
    private Position aPosition;

    public Box(Position pPosition) {
        assert pPosition != null;
        aPosition = pPosition;
        aBoxState = BoxState.EMPTY;
    }

    public void empty() {
        aBoxState = BoxState.EMPTY;
    }

    public void setState(BoxState pBoxState) {
        assert pBoxState != null;
        assert aBoxState == BoxState.EMPTY;
        aBoxState = pBoxState;
    }

    public BoxState getState() {
        return aBoxState;
    }

    public Position getPosition() {
        return aPosition;
    }
}
