package org.gameoflife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniverseTest {

    private Boolean[][] initialState = new Boolean[][]{
                {true, true, true},
                {false, false, true},
                {false, true, true},
        };

    private Boolean[][] newState = new Boolean[][]{
                {true, true, true},
                {false, false, true},
                {false, true, true},
        };
    private Universe universe;

    @Before
    public void init() {
        universe = new Universe(initialState);
    }

    @Test
    public void afterTheTurnCellsHaveNewState() {
        universe.turn();
        Assert.assertArrayEquals(newState, universe.getCells());
    }

    @Test
    public void cellsHaveInitialState() {
        Assert.assertArrayEquals(initialState, universe.getCells());
    }

}
