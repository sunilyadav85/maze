package com.bnp.bean;

public class Maze {

    private final int startRow;
    private final int startColumn;
    private final int finishRow;
    private final int finishColumn;
    private char[][] mazeArr;

    public Maze(int startRow, int startColumn, int finishRow, int finishColumn, char[][] mazeArr) {
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.finishRow = finishRow;
        this.finishColumn = finishColumn;
        this.mazeArr = mazeArr;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public int getFinishRow() {
        return finishRow;
    }

    public int getFinishColumn() {
        return finishColumn;
    }

    public char[][] getMazeArr() {
        return mazeArr;
    }
}
