package com.aamir.dungeonarena.battle;

import java.util.Scanner;

import com.aamir.dungeonarena.characters.Player;
import com.aamir.dungeonarena.characters.Enemy;

/**
 * Handles turn-based combat between player and enemy.
 */
public class BattleManager {

    private Scanner scanner = new Scanner(System.in);

    public void startBattle(Player player, Enemy enemy) {
        System.out.println("A wild " + enemy.getName() + " appears!");
        System.out.println();

        while (player.isAlive() && enemy.isAlive()) {
            playerTurn(player, enemy);

            if (enemy.isAlive()) {
                enemyTurn(player, enemy);
            }

            System.out.println();
        }

        if (player.isAlive()) {
            System.out.println("You defeated the " + enemy.getName() + "!");
        } else {
            System.out.println("You were defeated...");
        }
    }

    private void playerTurn(Player player, Enemy enemy) {
        System.out.println("Your HP: " + player.getHealth());
        System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
        System.out.println();

        System.out.println("Choose action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");

        int choice = scanner.nextInt();

        if (choice == 1) {
            int damage = player.attack();
            enemy.takeDamage(damage);

            System.out.println("You attack for " + damage + " damage!");
        } else if (choice == 2) {
            player.setDefending(true);
            System.out.println("You brace for incoming attack!");
        }
    }

    private void enemyTurn(Player player, Enemy enemy) {
        int damage = enemy.attack();
        player.takeDamage(damage);

        System.out.println(enemy.getName() + " attacks for " + damage + " damage!");

        player.setDefending(false);
    }
}