package com.tictactoe.views;

import com.tictactoe.models.Board;
import com.tictactoe.models.Game;

public class GameView {
    private final Game game;
    private final boolean emojiMode;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public GameView(Game game) {
        this(game, true);
    }

    public GameView(Game game, boolean emojiMode) {
        this.game = game;
        this.emojiMode = emojiMode;
    }

    private String getHeartSymbol() {
        if (emojiMode) {
            return " ❤️";
        } else {
            return " ♥";
        }
    }

    public void displayBoard() {
        Board board = game.getBoard();
        System.out.println(CYAN + "\n    0   1   2" + RESET);
        System.out.println(CYAN + "  +---+---+---+" + RESET);
        for (int i = 0; i < board.getSize(); i++) {
            System.out.print(CYAN + i + " |" + RESET);
            for (int j = 0; j < board.getSize(); j++) {
                char cell = board.getCell(i, j);
                String cellColor = cell == 'X' ? RED : (cell == 'O' ? BLUE : "");
                System.out.print(" " + cellColor + cell + RESET + " |");
            }
            System.out.println(CYAN + "\n  +---+---+---+" + RESET);
        }
        System.out.println();
    }

    public void displayGameStatus() {
        String status = game.getGameStatus();
        if (status.contains("wins")) {
            System.out.println(GREEN + status + getHeartSymbol() + RESET);
        } else {
            System.out.println(YELLOW + status + RESET);
        }
    }

    public void displayInvalidMove() {
        System.out.println(RED + "Invalid move! Try again." + RESET);
    }

    public void displayWelcome() {
        System.out.println("\n" + PURPLE + "╔════════════════════════════════════════╗");
        System.out.println("║         Welcome to Tic Tac Toe!        ║");
        System.out.println("╚════════════════════════════════════════╝" + RESET);
        System.out.println("\n" + YELLOW + "Players take turns entering coordinates (row column)");
        System.out.println("Player X goes first" + RESET + "\n");
    }
}
