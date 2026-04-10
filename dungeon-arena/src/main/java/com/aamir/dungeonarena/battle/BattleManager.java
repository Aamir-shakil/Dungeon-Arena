package com.aamir.dungeonarena.battle;

import java.util.Scanner;

import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.characters.Player;
import com.aamir.dungeonarena.observer.BattleLogDisplay;
import com.aamir.dungeonarena.observer.GameModel;
import com.aamir.dungeonarena.observer.StatsDisplay;

/**
 * Handles turn-based combat between the player and an enemy.
 */
public class BattleManager {

    private final Scanner scanner = new Scanner(System.in);
    private final GameModel gameModel;

    public BattleManager() {
        gameModel = new GameModel();
        gameModel.addObserver(new StatsDisplay());
        gameModel.addObserver(new BattleLogDisplay());
    }

    public void startBattle(Player player, Enemy enemy, int round) {
        updateModel(player, enemy, round, "A wild " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {
            playerTurn(player, enemy, round);

            if (enemy.isAlive()) {
                enemyTurn(player, enemy, round);
            }
        }

        if (player.isAlive()) {
            updateModel(player, enemy, round, "Victory! You defeated the " + enemy.getName() + ".");
        } else {
            updateModel(player, enemy, round, "Defeat... " + player.getName() + " has fallen.");
        }
    }

    private void playerTurn(Player player, Enemy enemy, int round) {
        System.out.println("Choose action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");

        int choice = readChoice();

        if (choice == 1) {
            int damage = player.attack();
            enemy.takeDamage(damage);
            updateModel(player, enemy, round,
                    player.getName() + " attacks " + enemy.getName() + " for " + damage + " damage.");
        } else {
            player.setDefending(true);
            updateModel(player, enemy, round,
                    player.getName() + " takes a defensive stance.");
        }
    }

    private void enemyTurn(Player player, Enemy enemy, int round) {
        int damage = enemy.attack();
        player.takeDamage(damage);

        updateModel(player, enemy, round,
                enemy.getName() + " attacks " + player.getName() + " for " + damage + " damage.");

        player.setDefending(false);
    }

    private int readChoice() {
        while (true) {
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice == 1 || choice == 2) {
                    return choice;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }

    private void updateModel(Player player, Enemy enemy, int round, String message) {
        gameModel.updateStats(
                player.getName(),
                player.getHealth(),
                player.getMaxHealth(),
                enemy.getName(),
                enemy.getHealth(),
                enemy.getMaxHealth(),
                round,
                message
        );
    }
}