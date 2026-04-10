package com.aamir.dungeonarena.state;

import java.util.Scanner;

import com.aamir.dungeonarena.main.Game;

/**
 * Handles the start menu state.
 */
public class MenuState implements GameState {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void handle(Game game) {
        System.out.println("=================================");
        System.out.println("      DUNGEON BATTLE ARENA       ");
        System.out.println("=================================");
        System.out.println();
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        System.out.println();

        if (choice == 1) {
            game.setState(new BattleState());
        } else {
            System.out.println("Exiting game...");
            System.exit(0);
        }
    }
}