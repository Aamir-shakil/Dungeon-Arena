package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.main.Game;

/**
 * State representing the game over condition.
 * Displays defeat message and stops the game loop.
 */
public class GameOverState implements GameState {

    /**
     * Executes the game over logic.
     */
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