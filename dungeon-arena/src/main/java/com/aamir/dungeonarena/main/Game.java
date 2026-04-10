package com.aamir.dungeonarena.main;

import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.characters.Goblin;
import com.aamir.dungeonarena.characters.Player;
import com.aamir.dungeonarena.state.GameState;
import com.aamir.dungeonarena.state.MenuState;

/**
 * Controls the main game flow and context for the State pattern.
 */
public class Game {

    private Player player;
    private Enemy currentEnemy;
    private GameState currentState;
    private boolean running;

    /**
     * Starts the application.
     */
    public void start() {
        player = new Player("Knight", 100, 20);
        currentEnemy = new Goblin();
        currentState = new MenuState();
        running = true;

        while (running) {
            currentState.handle(this);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    public void setCurrentEnemy(Enemy currentEnemy) {
        this.currentEnemy = currentEnemy;
    }

    public GameState getState() {
        return currentState;
    }

    public void setState(GameState currentState) {
        this.currentState = currentState;
    }

    public void stop() {
        running = false;
    }
}