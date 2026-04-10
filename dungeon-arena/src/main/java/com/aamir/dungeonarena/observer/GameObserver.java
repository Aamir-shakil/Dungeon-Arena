package com.aamir.dungeonarena.observer;

/**
 * Observer interface for classes that react to game model updates.
 */
public interface GameObserver {
    void update(GameModel model);
}