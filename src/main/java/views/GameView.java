package views;

import models.Board;
import models.Game;

public class GameView {
    private Game game;

    public GameView(Game game) {
        this.game = game;
    }

    public void displayBoard(){
        Board board = game.getBoard();
        System.out.println("\n    0   1   2");
        System.out.println("  +---+---+---+");
        for (int i = 0; i < board.getSize(); i++){
            System.out.print(i + " |");
            for (int j = 0; j < board.getSize(); j++){
                System.out.print(" " + board.getCell(i, j) + " |");
            }
            System.out.println("\n  +---+---+---+");
        }
        System.out.println();
    }

    public void displayGameStatus(){
        System.out.println(game.getGameStatus());
    }

    public void displayInvalidMove(){
        System.out.println("Invalid move! Try again.");
    }

    public void displayWelcome(){
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Players take turns entering coordinates (row column)");
        System.out.println("Player X goes first");
    }
}