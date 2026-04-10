package com.aamir.dungeonarena.decorator;

public class StrengthBoostDecorator extends CharacterDecorator {

    public StrengthBoostDecorator(Combatant wrappedCharacter) {
        super(wrappedCharacter);
    }

    @Override
    public int attack() {
        return wrappedCharacter.attack() + 5;
    }
}