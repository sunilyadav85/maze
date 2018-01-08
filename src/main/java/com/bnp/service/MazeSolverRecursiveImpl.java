package com.bnp.service;

import com.bnp.bean.Maze;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursiveImpl implements MazeSolver {

    private static final char START = 'S';
    private static final char END = 'E';
    private static final char PATH = '.';
    private static final char WALL = '#';

    @Override
    public boolean solveMaze(String fileName) throws IOException {
        Maze maze = initializeMaze(fileName);

        char[][] mazeArr = maze.getMazeArr();
        System.out.println("\n******  Input Maze  ******\n");
        printMaze(mazeArr);

        boolean result = findPath(mazeArr, maze.getStartRow(), maze.getStartColumn());

        mazeArr[maze.getStartRow()][maze.getStartColumn()] = START;
        System.out.println("\n******  Result Maze  ******\n");
        printMaze(mazeArr);

        return result;
    }

    private boolean findPath(char[][] mazeArr, int row, int column) {
        if (row < 0 || column < 0 || row >= mazeArr.length || column >= mazeArr[0].length) {
            return false;
        }
        if (mazeArr[row][column] == END) {
            return true;
        }
        if (mazeArr[row][column] == WALL || mazeArr[row][column] == PATH) {
            return false;
        }

        mazeArr[row][column] = PATH;

        if (findPath(mazeArr, row, column - 1)) {
            return true;
        }
        if (findPath(mazeArr, row + 1, column)) {
            return true;
        }
        if (findPath(mazeArr, row, column + 1)) {
            return true;
        }
        if (findPath(mazeArr, row - 1, column)) {
            return true;
        }

        mazeArr[row][column] = ' ';
        return false;
    }


    private void printMaze(char[][] mazeArr) {
        for (char[] row : mazeArr) {
            for (char character : row) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private Maze initializeMaze(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> lines = new ArrayList<>();
            String line;
            int columnLength = -1;
            while ((line = StringUtils.trim(br.readLine())) != null) {
                if (columnLength == -1) {
                    columnLength = line.length();
                }

                if (columnLength != line.length()) {
                    throw new IllegalStateException(String.format("All column length must be equal to %d", columnLength));
                }
                lines.add(line);
            }

            char[][] mazeArr = new char[lines.size()][columnLength];
            int startRow = -1;
            int startColumn = -1;
            int finishRow = -1;
            int finishColumn = -1;
            for (int row = 0; row < lines.size(); row++) {
                line = lines.get(row);
                for (int column = 0; column < columnLength; column++) {
                    mazeArr[row][column] = line.charAt(column);

                    if (mazeArr[row][column] == START) {
                        startRow = row;
                        startColumn = column;
                    }
                    if (mazeArr[row][column] == END) {
                        finishRow = row;
                        finishColumn = column;
                    }
                }
            }
            return new Maze(startRow, startColumn, finishRow, finishColumn, mazeArr);
        } catch (IOException e) {
            throw e;
        }
    }
}
