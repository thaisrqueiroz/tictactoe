package controllers;

import java.util.Scanner;

import models.Game;
import views.GameView;

public class GameController {
    private Game game;
    private GameView view;
    private Scanner scanner;

    public GameController(){
        game = new Game();
        view = new GameView(game);
        scanner = new Scanner(System.in);
    }

    public void StartGame(){
        view.displayWelcome();
        while (!game.isGameOver()) {
            view.displayBoard();
            view.displayGameStatus();
            System.out.print("Enter coordinates (row column): ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
            if (!game.makeMove(row,col)) {
                view.displayInvalidMove();
            }
            } catch (Exception e) {
                scanner.nextLine();
                view.displayInvalidMove();
            }
        }
        view.displayBoard();
        view.displayGameStatus();
        scanner.close();
    }
}



