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

    @Test
    public void cellsHaveInitialState() {
        Assert.assertArrayEquals(initialState, universe.getCells());
    }

    @Test
    public void iCanAccessCell() {
        Assert.assertFalse(universe.getCell(1, 0));
        Assert.assertTrue(universe.getCell(1, 2));

    }

    @Test
    public void aDeadCellWithExactThreeNeighboursComesAlive() {
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
    public void extractNeighboursForMiddleCell() {
        Boolean[] neighbours = new Boolean[]{true, true, true, true, true, true, false, false};
        Boolean[] realNeighbours = universe.getNeighbours(1, 1);
        Assert.assertArrayEquals(neighbours, realNeighbours);
    }

    @Test
    public void extractNeighboursForCellAtTheUpperBorder() {
        Boolean[] neighbours = new Boolean[]{false, false, false, true, false, false, false, false};
        Boolean[] realNeighbours = universe.getNeighbours(0, 0);
        Assert.assertArrayEquals(neighbours, realNeighbours);
    }

    @Test
    public void extractNeigboursForCellAtTheBottomBorder() {
        Boolean[] neighbours = new Boolean[]{false, true, false, false, false, false, false, true};
        Boolean[] realNeighbours = universe.getNeighbours(2, 2);
        Assert.assertArrayEquals(neighbours, realNeighbours);
    }

    @Test
    public void afterTheTurnCellsHaveNewState() {
        universe.turn();
        Assert.assertArrayEquals(nextState, universe.getCells());
    }

    @Before
    public void init() {
        universe = new Universe(initialState);
    }

}
