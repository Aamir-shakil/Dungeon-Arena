package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.battle.BattleManager;
import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.main.Game;

/**
 * State responsible for handling the battle phase of the game.
 * Displays round information and starts combat.
 */
public class BattleState implements GameState {

    /**
     * Executes the battle state logic.
     * Starts combat and transitions to the next state depending on the outcome.
     */
    @Override
    public void handle(Game game) {
        Enemy enemy = game.getCurrentEnemy();

        System.out.println();
        System.out.println("=================================");
        System.out.println("Round " + game.getRound());
        System.out.println("=================================");
        System.out.println("Enemy: " + enemy.getName());
        System.out.println();

        BattleManager battleManager = new BattleManager();
        battleManager.startBattle(game.getActivePlayer(), enemy, game.getRound());

        if (game.getActivePlayer().isAlive()) {
            game.setState(new VictoryState());
        } else {
            game.setState(new GameOverState());
        }
    }
}