package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.battle.BattleManager;
import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.main.Game;
import com.aamir.dungeonarena.decorator.Combatant;

public class BattleState implements GameState {

    @Override
    public void handle(Game game) {
        Enemy enemy = game.getCurrentEnemy();
        BattleManager battleManager = new BattleManager();

        battleManager.startBattle(game.getActivePlayer(), enemy, game.getRound());

        if (game.getActivePlayer().isAlive()) {
            game.setState(new VictoryState());
        } else {
            game.setState(new GameOverState());
        }
    }
}