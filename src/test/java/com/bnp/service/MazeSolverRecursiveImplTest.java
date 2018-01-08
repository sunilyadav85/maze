package com.bnp.service;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MazeSolverRecursiveImplTest {

    @Test
    public void shouldSolveMaze() throws Exception {

        // Given
        String fileName = Paths.get(ClassLoader.getSystemResource("SolvableMaze.txt").toURI()).toString();

        MazeSolver solver = new MazeSolverRecursiveImpl();

        // When
        boolean result = solver.solveMaze(fileName);

        // Then
        assertThat(result, equalTo(true));
    }

    @Test
    public void shouldNotSolveMaze() throws Exception {

        // Given
        String fileName = Paths.get(ClassLoader.getSystemResource("UnSolvableMaze.txt").toURI()).toString();

        MazeSolver solver = new MazeSolverRecursiveImpl();

        // When
        boolean result = solver.solveMaze(fileName);

        // Then
        assertThat(result, equalTo(false));
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenInvalidFile() throws Exception {
        // Given
        MazeSolver solver = new MazeSolverRecursiveImpl();

        // When
        solver.solveMaze("Invalid.txt");

        // Then
    }
}