package com.aamir.dungeonarena.observer;

/**
 * Displays player and enemy stats when the model updates.
 */
public class StatsDisplay implements GameObserver {

    @Override
    public void update(GameModel model) {
        System.out.println("---------------------------------");
        System.out.println("Round: " + model.getRound());
        System.out.println(model.getPlayerName() + " HP: " + model.getPlayerHealth() + "/" + model.getPlayerMaxHealth());
        System.out.println(model.getEnemyName() + " HP: " + model.getEnemyHealth() + "/" + model.getEnemyMaxHealth());
    }
}