package com.aamir.dungeonarena.main;

import com.aamir.dungeonarena.characters.Goblin;
import com.aamir.dungeonarena.characters.Orc;
import com.aamir.dungeonarena.characters.Player;

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
        Orc orc = new Orc();

        System.out.println("Player created:");
        System.out.println(player);
        System.out.println();

        System.out.println("Enemies created:");
        System.out.println(goblin);
        System.out.println(orc);
        System.out.println();

        System.out.println("Base project structure is working.");
    }
}