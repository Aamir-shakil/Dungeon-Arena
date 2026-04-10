package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.battle.BattleManager;
import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.main.Game;

/**
 * Handles the main battle phase.
 */
public class BattleState implements GameState {

    @Override
    public void handle(Game game) {
        Enemy enemy = game.getCurrentEnemy();
        BattleManager battleManager = new BattleManager();

        battleManager.startBattle(game.getPlayer(), enemy, game.getRound());

        if (game.getPlayer().isAlive()) {
            game.setState(new VictoryState());
        } else {
            game.setState(new GameOverState());
        }
    }
}