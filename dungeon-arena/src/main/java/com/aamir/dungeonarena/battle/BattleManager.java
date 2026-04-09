package com.aamir.dungeonarena.battle;

import java.util.Scanner;

import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.characters.Player;

/**
 * Handles turn-based combat between the player and an enemy.
 */
public class BattleManager {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts a battle between the player and a single enemy.
     *
     * @param player the player
     * @param enemy the enemy
     */
    public void startBattle(Player player, Enemy enemy) {
        printBattleIntro(enemy);

        int turnNumber = 1;

        while (player.isAlive() && enemy.isAlive()) {
            printTurnHeader(turnNumber);
            displayStats(player, enemy);

            playerTurn(player, enemy);

            if (enemy.isAlive()) {
                enemyTurn(player, enemy);
            }

            System.out.println();
            turnNumber++;
        }

        printBattleResult(player, enemy);
    }

    private void printBattleIntro(Enemy enemy) {
        System.out.println("=================================");
        System.out.println("Battle Start");
        System.out.println("=================================");
        System.out.println("A wild " + enemy.getName() + " appears!");
        System.out.println();
    }

    private void printTurnHeader(int turnNumber) {
        System.out.println("---------------------------------");
        System.out.println("Turn " + turnNumber);
        System.out.println("---------------------------------");
    }

    private void displayStats(Player player, Enemy enemy) {
        System.out.println(player.getName() + " HP: " + player.getHealth() + "/" + player.getMaxHealth());
        System.out.println(enemy.getName() + " HP: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
        System.out.println();
    }

    private void playerTurn(Player player, Enemy enemy) {
        System.out.println("Choose action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");

        int choice = readChoice();

        if (choice == 1) {
            int damage = player.attack();
            enemy.takeDamage(damage);
            System.out.println(player.getName() + " attacks " + enemy.getName() + " for " + damage + " damage.");
        } else {
            player.setDefending(true);
            System.out.println(player.getName() + " takes a defensive stance.");
        }
    }

    private void enemyTurn(Player player, Enemy enemy) {
        int damage = enemy.attack();
        player.takeDamage(damage);
        System.out.println(enemy.getName() + " attacks " + player.getName() + " for " + damage + " damage.");

        player.setDefending(false);
    }

    private void printBattleResult(Player player, Enemy enemy) {
        System.out.println("=================================");
        System.out.println("Battle Result");
        System.out.println("=================================");

        if (player.isAlive()) {
            System.out.println("Victory! You defeated the " + enemy.getName() + ".");
        } else {
            System.out.println("Defeat... " + player.getName() + " has fallen.");
        }
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
}