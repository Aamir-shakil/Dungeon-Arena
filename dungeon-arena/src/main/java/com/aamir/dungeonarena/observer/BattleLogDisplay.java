package com.aamir.dungeonarena.observer;

/**
 * Displays the latest battle event message.
 */
public class BattleLogDisplay implements GameObserver {

    @Override
    public void update(GameModel model) {
        System.out.println("Event: " + model.getMessage());
        System.out.println();
    }
}