package com.tictactoe.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameControllerTest {
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;
    private PrintStream originalOut;
    
    @BeforeEach 
    void setUp() { 
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        if (inputStream != null) {
            try {
             inputStream.close();   
            } catch (IOException ignored) {
            }
        }
    }

    @Test 
    void testStartGameWithValidInput() {
        String input = "0 0\n1 1\n0 1\n1 0\n0 2\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        GameController controller = new GameController();
        controller.startGame();
        String output = outputStream.toString();
        assertTrue(output.contains("Welcome to Tic Tac Toe"));
        assertTrue(output.contains("X wins"));
    }
}
