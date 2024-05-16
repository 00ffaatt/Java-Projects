package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoxTest {

    private final Position position1 = new Position(1, 1);

    @Test
    public void testEmpty() {
        Box emptyBox = new Box(position1);
        emptyBox.setState(BoxState.CIRCLE);
        emptyBox.empty();
        assertEquals(emptyBox.getState(), BoxState.EMPTY);
    }

    @Test
    public void testSetState() {
        Box box1 = new Box(position1);
        box1.setState(BoxState.CIRCLE);
        assertEquals(box1.getState(), BoxState.CIRCLE);
    }

}
