package com.tictactoe.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp(){
        board = new Board();
    }

    @Test
    void testCheckWinner() {
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWinner('X'));
    }

    @Test
    void testGetCell() {
        board.makeMove(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0));
        assertEquals(' ', board.getCell(1, 1));
    }

    @Test
    void testGetSize() {
        assertEquals(3, board.getSize());
    }

    @Test
    void testIsFull() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board.makeMove(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsValidMove() {
        assertTrue(board.isValidMove(0, 0));
        board.makeMove(0, 0, 'X');
        assertFalse(board.isValidMove(0,0));
        assertFalse(board.isValidMove(3,4));
    }

    @Test
    void testMakeMove() {
        board.makeMove(0, 0, 'X');
        assertEquals('X', board.getCell(0, 0));
        assertFalse(board.makeMove(0,0, 'O'));
    }
}