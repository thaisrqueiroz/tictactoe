package com.tictactoe.views;

import com.tictactoe.models.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameViewTest {
    private GameView gameView;
    private Game game;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        game = new Game();
        gameView = new GameView(game);
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testDisplayBoard() {
        gameView.displayBoard();
        String output = outputStream.toString();

        assertTrue(output.contains("0   1   2"));
        assertTrue(output.contains("+---+---+---+"));
        assertTrue(output.contains("0 |"));
        assertTrue(output.contains("1 |"));
        assertTrue(output.contains("2 |"));
    }

    @Test
    void testDisplayGameStatus() {
        gameView.displayGameStatus();
        String output = outputStream.toString();
        assertTrue(output.contains("Game in progress"));
        assertTrue(output.contains("Current player"));

        outputStream.reset();

        game.makeMove(0, 0); 
        game.makeMove(1, 0); 
        game.makeMove(0, 1); 
        game.makeMove(1, 1); 
        game.makeMove(0, 2); 

        gameView.displayGameStatus();
        output = outputStream.toString();
        assertTrue(output.contains("wins"));
    }

    @Test
    void testDisplayInvalidMove() {
        gameView.displayInvalidMove();
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid move"));
        assertTrue(output.contains("Try again"));
    }

    @Test
    void testDisplayWelcome() {
        gameView.displayWelcome();
        String output = outputStream.toString();

        assertTrue(output.contains("Welcome to Tic Tac Toe"));
        assertTrue(output.contains("Players take turns entering coordinates"));
        assertTrue(output.contains("Player X goes first"));
    }
}
