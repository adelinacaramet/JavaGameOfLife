package org.gameoflife;

public class Universe {

    private Boolean[][] cells;

    public Universe(Boolean[][] cells) {
        this.cells = cells;
    }

    public void turn() {
        Boolean[][] nextState = new Boolean[cells.length][cells[cells.length-1].length];
        for(int row = 0; row < cells.length; row++) {
            for(int col = 0; col < cells[cells.length-1].length; col++) {
                nextState[row][col] = isAliveNextTurn(cells[row][col], getNeighboursForCellAt(row, col));
            }
        }
        setCells(nextState);
    }

    public Boolean isAliveNextTurn(Boolean cell, Boolean[] neighbours) {
        int count = 0;
        for (Boolean neighbour : neighbours) {
            if (neighbour) count++;
        }
        return (!cell && count == 3) || (cell && count == 2) || (cell && count == 3);
    }

    private Boolean[] getNeighboursForCellAt(int row, int column) {
        Boolean[] neighbours = new Boolean[8];
        neighbours[0] = getCell(row - 1, column - 1);
        neighbours[1] = getCell(row - 1, column);
        neighbours[2] = getCell(row - 1, column + 1);
        neighbours[3] = getCell(row, column + 1);
        neighbours[4] = getCell(row + 1, column + 1);
        neighbours[5] = getCell(row + 1, column);
        neighbours[6] = getCell(row + 1, column - 1);
        neighbours[7] = getCell(row, column - 1);
        return neighbours;
    }

    private boolean getCell(int row, int column) {
        if (row < 0 || column < 0) {
            return false;
        }
        if (row >= cells.length || column >= cells[cells.length - 1].length) {
            return false;
        }
        return cells[row][column];
    }

    public Boolean[][] getCells() {
        return cells;
    }

    public void setCells(Boolean[][] cells) {
        this.cells = cells;
    }
}
