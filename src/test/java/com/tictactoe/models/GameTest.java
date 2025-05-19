package com.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testGetBoard() {
        assertNotNull(game.getBoard());
        assertTrue(game.getBoard() instanceof Board);
    }

    @Test
    void testGetCurrentPlayer() {
        assertNotNull(game.getCurrentPlayer());
        assertEquals('X', game.getCurrentPlayer().getSymbol());
    }

    @Test
    void testGetGameStatus() {
        assertEquals("Game in progress. Current player: PlayerX", game.getGameStatus());
        game.makeMove(0, 0); 
        game.makeMove(1, 0); 
        game.makeMove(0, 1);
        game.makeMove(1, 1); 
        game.makeMove(0, 2);
        assertTrue(game.getGameStatus().contains("wins!"));
    }

    @Test
    void testGetLastError() {
        assertNull(game.getLastError());

        game.makeMove(3, 3);
        assertEquals("Coordinates must be between 0 and 2", game.getLastError());

        game.makeMove(0, 0);
        game.makeMove(0, 0);
        assertEquals("This cell is already occupied", game.getLastError());
    }

    @Test
    void testIsGameOver() {
        assertFalse(game.isGameOver());

        game.makeMove(0, 0); 
        game.makeMove(1, 0); 
        game.makeMove(0, 1); 
        game.makeMove(1, 1); 
        game.makeMove(0, 2); 
        assertTrue(game.isGameOver());
    }

    @Test
    void testMakeMove() {

        assertTrue(game.makeMove(0, 0));
        assertEquals('O', game.getCurrentPlayer().getSymbol());

        assertFalse(game.makeMove(3, 3));

        assertFalse(game.makeMove(0, 0));

        game.makeMove(0, 1); 
        game.makeMove(0, 2); 
        game.makeMove(1, 1);
        game.makeMove(1, 0); 
        game.makeMove(1, 2); 
        game.makeMove(2, 1); 
        game.makeMove(2, 0); 
        game.makeMove(2, 2); 
        assertTrue(game.isGameOver()); 
        assertFalse(game.makeMove(0, 0)); 
    }
}
