package com.aamir.dungeonarena.characters;

/**
 * Represents the human-controlled player character.
 */
public class Player extends Character {

    /**
     * Constructs a player with the given name, health, and attack power.
     *
     * @param name player's name
     * @param maxHealth player's maximum health
     * @param attackPower player's attack strength
     */
    public Player(String name, int maxHealth, int attackPower) {
        super(name, maxHealth, attackPower);
    }
}