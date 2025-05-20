package com.tictactoe.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void testGetName() {
        Player player = new Player ('X');
        assertEquals("PlayerX", player.getName());
        Player player1 = new Player ('A');
        assertEquals("PlayerA", player1.getName());
    }

    @Test
    void testGetSymbol() {
        Player player = new Player ('S');
        assertEquals('S', player.getSymbol());
    }
}