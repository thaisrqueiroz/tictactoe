package com.tictactoe.models;

public class Player {
    private final char symbol;
    private String name;

    public Player(char symbol) {
        this.symbol = symbol;
        this.name = "Player" + symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}