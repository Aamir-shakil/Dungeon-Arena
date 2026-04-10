package com.aamir.dungeonarena.characters;
import com.aamir.dungeonarena.decorator.Combatant;

/**
 * Abstract base class for all combat characters in the game.
 * It provides shared state and behaviour such as health, attack,
 * damage handling, and defensive stance.
 */
public abstract class Character implements Combatant {
    private String name;
    private int maxHealth;
    private int health;
    private int attackPower;
    private boolean defending;

    /**
     * Constructs a character with a name, maximum health, and attack power.
     *
     * @param name        the character's name
     * @param maxHealth   the maximum and starting health
     * @param attackPower the base attack damage
     */
    public Character(String name, int maxHealth, int attackPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.defending = false;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public boolean isDefending() {
        return defending;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    /**
     * Reduces health based on incoming damage.
     * If the character is defending, damage is halved.
     *
     * @param damage the incoming damage value
     */
    public void takeDamage(int damage) {
        int finalDamage = damage;

        if (defending) {
            finalDamage = damage / 2;
        }

        health -= finalDamage;

        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Restores health up to the maximum health limit.
     *
     * @param amount amount of health to restore
     */
    public void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    /**
     * Checks whether the character is still alive.
     *
     * @return true if health is above zero, otherwise false
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Returns the amount of damage this character deals.
     * This method supports polymorphism and can be overridden later.
     *
     * @return attack damage
     */
    public int attack() {
        return attackPower;
    }

    @Override
    public String toString() {
        return name + " | HP: " + health + "/" + maxHealth + " | ATK: " + attackPower;
    }
}