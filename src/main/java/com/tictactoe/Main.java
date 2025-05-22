package com.tictactoe;

import com.tictactoe.controllers.GameController;

public class Main {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.startGame();
    }
}