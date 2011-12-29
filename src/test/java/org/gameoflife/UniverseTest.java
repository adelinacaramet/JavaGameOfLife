package org.gameoflife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UniverseTest {

    private Universe universe;

    private Boolean[][] initialState = new Boolean[][]{
            {true, true, true},
            {false, false, true},
            {false, true, true},
    };
    private Boolean[][] nextState = new Boolean[][]{
            {false, true, true},
            {false, false, false},
            {false, true, true},
    };

    @Test
    public void cellsHaveInitialState() {
        Assert.assertArrayEquals(initialState, universe.getCells());
    }

    @Test
    public void iCanAccessCell() {
        Assert.assertFalse(universe.getCell(1, 0));
        Assert.assertTrue(universe.getCell(1, 2));

    }

/*
    @Test
    public void aDeadCellWithExactThreeNeighboursComesAlive() {
        Boolean state = isAlive(x, y);
        Assert.assertTrue(state);
    }
*/

    @Test
    @Ignore
    public void afterTheTurnCellsHaveNewState() {
        universe.turn();
        Assert.assertArrayEquals(nextState, universe.getCells());
    }

    @Before
    public void init() {
        universe = new Universe(initialState);
    }

}
