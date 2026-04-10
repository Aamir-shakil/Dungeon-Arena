package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.main.Game;

/**
 * Represents a state in the game flow.
 */
public interface GameState {
    void handle(Game game);
}