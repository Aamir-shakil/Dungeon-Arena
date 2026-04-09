package com.aamir.dungeonarena.main;

import com.aamir.dungeonarena.battle.BattleManager;
import com.aamir.dungeonarena.characters.Goblin;
import com.aamir.dungeonarena.characters.Orc;
import com.aamir.dungeonarena.characters.Player;
import com.aamir.dungeonarena.battle.BattleManager;

/**
 * Controls the initial startup flow of the application.
 * Later, this class will manage game state and progression.
 */
public class Game {

    /**
     * Starts the application and demonstrates the base class structure.
     */
    public void start() {
        System.out.println("=================================");
        System.out.println("      DUNGEON BATTLE ARENA       ");
        System.out.println("=================================");
        System.out.println();

        Player player = new Player("Knight", 100, 20);
        Goblin goblin = new Goblin();

        BattleManager battleManager = new BattleManager();
        battleManager.startBattle(player, goblin);
    }
}