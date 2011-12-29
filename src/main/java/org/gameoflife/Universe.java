package org.gameoflife;

public class Universe {

    private Boolean[][] cells; // row

    public Universe(Boolean[][] cells) {
        this.cells = cells;
    }


    public void turn() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public Boolean[][] getCells() {
        return cells;
    }

    public boolean getCell(int row, int column) {
        if (row < 0 || column < 0) {
            return false;
        }
        if (row >= cells.length || column >= cells[cells.length - 1].length) {
            return false;
        }
        return cells[row][column];
    }

    public Boolean isAlive(Boolean cell, Boolean[] neighbours) {
        int count = 0;
        for (Boolean neighbour : neighbours) {
            if (neighbour) count++;
        }
        return (!cell && count == 3) || (cell && count == 2) || (cell && count == 3);
    }

    public Boolean[] getNeighbours(int row, int column) {
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
}
