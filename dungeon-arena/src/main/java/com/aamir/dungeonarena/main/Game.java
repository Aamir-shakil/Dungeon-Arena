package com.aamir.dungeonarena.main;

import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.characters.Goblin;
import com.aamir.dungeonarena.characters.Orc;
import com.aamir.dungeonarena.characters.Player;
import com.aamir.dungeonarena.decorator.Combatant;
import com.aamir.dungeonarena.state.GameState;
import com.aamir.dungeonarena.state.MenuState;
import com.aamir.dungeonarena.characters.OrcBoss;

public class Game {

    private Player player;
    private Combatant activePlayer;
    private Enemy currentEnemy;
    private GameState currentState;
    private boolean running;
    private int round;

    public void start() {
        player = new Player("Knight", 100, 20);
        activePlayer = player;
        round = 1;
        currentEnemy = createEnemy(round);
        currentState = new MenuState();
        running = true;

        while (running) {
            currentState.handle(this);
        }
    }

    public Enemy createEnemy(int round) {
    if (round == 1) {
        return new Goblin();
    } 
    else if (round == 2) {
        if (Math.random() < 0.5) {
            return new Orc();
        } else {
            return new Goblin();
        }
    } 
    else {
        return new OrcBoss();
    }
}

    public Player getPlayer() {
        return player;
    }

    public Combatant getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Combatant activePlayer) {
        this.activePlayer = activePlayer;
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

    public int getRound() {
        return round;
    }

    public void nextRound() {
        round++;
        currentEnemy = createEnemy(round);
    }

    public void resetActivePlayer() {
        activePlayer = player;
    }
}