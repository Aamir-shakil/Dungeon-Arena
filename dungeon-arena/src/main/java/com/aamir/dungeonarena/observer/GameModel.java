package com.aamir.dungeonarena.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores game data and notifies observers when data changes.
 */
public class GameModel implements GameSubject {

    private final List<GameObserver> observers = new ArrayList<>();

    private String playerName;
    private int playerHealth;
    private int playerMaxHealth;

    private String enemyName;
    private int enemyHealth;
    private int enemyMaxHealth;

    private int round;
    private String message;

    @Override
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(this);
        }
    }

    public void updateStats(String playerName, int playerHealth, int playerMaxHealth,
                            String enemyName, int enemyHealth, int enemyMaxHealth,
                            int round, String message) {
        this.playerName = playerName;
        this.playerHealth = playerHealth;
        this.playerMaxHealth = playerMaxHealth;
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyMaxHealth = enemyMaxHealth;
        this.round = round;
        this.message = message;

        notifyObservers();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyMaxHealth() {
        return enemyMaxHealth;
    }

    public int getRound() {
        return round;
    }

    public String getMessage() {
        return message;
    }
}