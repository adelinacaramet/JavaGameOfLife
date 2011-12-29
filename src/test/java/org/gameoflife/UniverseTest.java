package org.gameoflife;

import org.junit.Assert;
import org.junit.Before;
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
            {true, false, false},
            {false, true, true},
    };
    private Boolean[][] nextNextState = new Boolean[][]{
            {false, true, false},
            {true, false, false},
            {false, true, false},
    };

    @Before
    public void init() {
        universe = new Universe(initialState);
    }

    @Test
    public void aDeadCellWithExactlyThreeNeighboursComesAlive() {
        Boolean cell = false;
        Boolean[] neighbours = new Boolean[]{true, true, true, false, false, false, false, false};
        Boolean state = universe.isAliveNextTurn(cell, neighbours);
        Assert.assertTrue(state);
    }

    @Test
    public void anAliveCellWithTwoNeighboursRemainsAlive() {
        Boolean cell = true;
        Boolean[] neighbours = new Boolean[]{false, true, false, false, false, true, false, false};
        Boolean state = universe.isAliveNextTurn(cell, neighbours);
        Assert.assertTrue(state);
    }

    @Test
    public void anAliveCellWithThreeNeighboursRemainsAlive() {
        Boolean cell = true;
        Boolean[] neighbours = new Boolean[]{false, true, false, false, true, true, false, false};
        Boolean state = universe.isAliveNextTurn(cell, neighbours);
        Assert.assertTrue(state);
    }

    @Test
    public void anAliveCellWithFourNeighboursDies() {
        Boolean cell = true;
        Boolean[] neighbours = new Boolean[]{true, true, false, false, true, true, false, false};
        Boolean state = universe.isAliveNextTurn(cell, neighbours);
        Assert.assertFalse(state);
    }

    @Test
    public void afterTheTurnCellsHaveANewState() {
        universe.turn();
        Assert.assertArrayEquals(nextState, universe.getCells());
    }

    @Test
    public void afterTheSecondTurnCellsHaveANewState() {
        universe.turn();
        universe.turn();
        Assert.assertArrayEquals(nextNextState, universe.getCells());
    }
}
