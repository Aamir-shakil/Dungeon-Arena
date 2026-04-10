package com.aamir.dungeonarena.characters;

import java.util.Random;

/**
 * A weaker enemy type with lower health and moderate attack.
 */
public class Goblin extends Enemy {

    private final Random random = new Random();
    private boolean quickStrikeTriggered;

    public Goblin() {
        super("Goblin", 50, 12);
    }

    @Override
    public int attack() {
        quickStrikeTriggered = random.nextInt(100) < 30;

        if (quickStrikeTriggered) {
            return getAttackPower() + 6;
        }

        return getAttackPower();
    }

    @Override
    public String getAttackMessage() {
        if (quickStrikeTriggered) {
            return getName() + " uses Quick Strike!";
        }

        return getName() + " slashes at you.";
    }
}