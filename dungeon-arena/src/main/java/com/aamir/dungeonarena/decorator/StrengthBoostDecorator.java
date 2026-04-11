package com.aamir.dungeonarena.decorator;

/**
 * Decorator that increases the attack damage of the wrapped combatant.
 * Provides a temporary offensive boost.
 */
public class StrengthBoostDecorator extends CharacterDecorator {

    /**
     * Applies a strength boost to the given combatant.
     */
    public StrengthBoostDecorator(Combatant wrappedCharacter) {
        super(wrappedCharacter);
    }

    /**
     * Increases attack damage before returning the result.
     */
    @Override
    public int attack() {
        return wrappedCharacter.attack() + 5;
    }
}