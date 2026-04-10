package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.main.Game;

/**
 * Handles the victory state after a successful battle.
 */
public class VictoryState implements GameState {

    @Override
    public void handle(Game game) {
        System.out.println();
        System.out.println("You survived the battle!");
        System.out.println("Thanks for playing.");
        game.stop();
    }
}