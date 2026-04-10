package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.main.Game;

public class GameOverState implements GameState {

    @Override
    public void handle(Game game) {
        System.out.println();
        System.out.println("=================================");
        System.out.println("Game Over");
        System.out.println("=================================");
        System.out.println("You were defeated in round " + game.getRound() + ".");
        game.stop();
    }
}