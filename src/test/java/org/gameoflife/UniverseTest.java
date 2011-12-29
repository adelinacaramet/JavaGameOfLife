package org.gameoflife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniverseTest {

    private Boolean[][] cells;
    private Boolean[][] initialState = new Boolean[][]{
                {true, true, true},
                {false, false, true},
                {false, true, true},
        };

    @Before
    public void init() {
        cells = initialState;
    }

    @Test
    public void cellsHaveInitialState() {
        Assert.assertArrayEquals(initialState, cells);
    }
}
