package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.main.Game;

/**
 * Handles the losing state.
 */
public class GameOverState implements GameState {

    @Override
    public void handle(Game game) {
        System.out.println();
        System.out.println("Game Over.");
        game.stop();
    }
}