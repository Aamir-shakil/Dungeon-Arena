package com.aamir.dungeonarena.state;

import com.aamir.dungeonarena.main.Game;

public class VictoryState implements GameState {

    @Override
    public void handle(Game game) {
        System.out.println();
        System.out.println("You won round " + game.getRound() + "!");

        if (game.getRound() >= 3) {
            System.out.println("You cleared the dungeon!");
            game.stop();
            return;
        }

        game.nextRound();
        game.setState(new BattleState());
    }
}