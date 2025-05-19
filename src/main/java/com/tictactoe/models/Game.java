package com.tictactoe.models;

public class Game {
    private Board board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;
    private boolean gameOver;
    private String lastError;

    public Game() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
        gameOver = false;
        lastError = null;
    }

    public boolean makeMove(int row, int col) {
        lastError = null;

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            lastError = "Coordinates must be between 0 and 2";
            return false;
        }

        if (gameOver) {
            lastError = "Game is already over";
            return false;
        }

        if (!board.isValidMove(row, col)) {
            lastError = "This cell is already occupied";
            return false;
        }

        if (board.makeMove(row, col, currentPlayer.getSymbol())) {
            if (board.checkWinner(currentPlayer.getSymbol())) {
                gameOver = true;
            } else if (board.isFull()) {
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            }
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public String getLastError() {
        return lastError;
    }

    public String getGameStatus() {
        if (!gameOver) {
            return "Game in progress. Current player: " + currentPlayer.getName();
        }
        if (board.checkWinner('X')) {
            return playerX.getName() + " wins!";
        } else if (board.checkWinner('O')) {
            return playerO.getName() + " wins!";
        } else {
            return "It's a draw!";
        }
    }
}