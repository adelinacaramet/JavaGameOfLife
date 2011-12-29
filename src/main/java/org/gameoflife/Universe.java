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
        return cells[row][column];
    }
}
