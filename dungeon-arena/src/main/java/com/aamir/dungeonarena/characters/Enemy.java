package com.aamir.dungeonarena.characters;

/**
 * Abstract superclass for all enemy types in the game.
 * Specific enemy classes inherit from this class.
 */
public abstract class Enemy extends Character {

    /**
     * Constructs an enemy with the given name, health, and attack power.
     *
     * @param name enemy name
     * @param maxHealth enemy maximum health
     * @param attackPower enemy attack strength
     */
    public Enemy(String name, int maxHealth, int attackPower) {
        super(name, maxHealth, attackPower);
    }
}