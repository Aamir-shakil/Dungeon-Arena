package com.aamir.dungeonarena.decorator;

/**
 * Decorator that reduces incoming damage for the wrapped combatant.
 * Provides a temporary defensive boost.
 */
public class ShieldBoostDecorator extends CharacterDecorator {

    /**
     * Applies a shield boost to the given combatant.
     */
    public ShieldBoostDecorator(Combatant wrappedCharacter) {
        super(wrappedCharacter);
    }

    /**
     * Reduces incoming damage before passing it to the wrapped combatant.
     */
    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(0, damage - 5);
        wrappedCharacter.takeDamage(reducedDamage);
    }
}