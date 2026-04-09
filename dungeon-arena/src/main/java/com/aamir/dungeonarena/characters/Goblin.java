package com.aamir.dungeonarena.characters;

/**
 * A weaker enemy type with lower health and moderate attack.
 */
public class Goblin extends Enemy {

    /**
     * Constructs a Goblin with predefined stats.
     */
    public Goblin() {
        super("Goblin", 50, 12);
    }
}