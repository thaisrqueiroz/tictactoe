package com.tictactoe.models;

public class Board {
    private static final int SIZE = 3;
    private final char[][] board;
    private int movesCount;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        movesCount = 0;
    }

    public boolean makeMove(int row, int col, char player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            movesCount++;
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ';
    }

    public boolean isFull() {
        return movesCount == SIZE * SIZE;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return SIZE;
    }

    public boolean checkWinner(char player) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
}