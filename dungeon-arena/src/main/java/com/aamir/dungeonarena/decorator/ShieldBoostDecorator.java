package com.aamir.dungeonarena.decorator;

public class ShieldBoostDecorator extends CharacterDecorator {

    public ShieldBoostDecorator(Combatant wrappedCharacter) {
        super(wrappedCharacter);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(0, damage - 5);
        wrappedCharacter.takeDamage(reducedDamage);
    }
}