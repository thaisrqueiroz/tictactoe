package com.tictactoe.controllers;

import java.util.Scanner;

import com.tictactoe.models.Game;
import com.tictactoe.views.GameView;

public class GameController {
    private Game game;
    private GameView view;
    private Scanner scanner;

    public GameController() {
        game = new Game();
        view = new GameView(game);
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        view.displayWelcome();
        while (!game.isGameOver()) {
            view.displayBoard();
            view.displayGameStatus();
            System.out.print("Enter coordinates (row column): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                view.displayInvalidMove();
                continue;
            }

            String[] coordinates = input.split("\\s+");
            if (coordinates.length != 2) {
                System.out.println("Please enter coordinates in format: row column (with space between numbers)");
                continue;
            }

            try {
                int row = Integer.parseInt(coordinates[0]);
                int col = Integer.parseInt(coordinates[1]);
                if (!game.makeMove(row, col)) {
                    view.displayInvalidMove();
                }
            } catch (NumberFormatException e) {
                view.displayInvalidMove();
            }
        }
        view.displayBoard();
        view.displayGameStatus();
        scanner.close();
    }
}