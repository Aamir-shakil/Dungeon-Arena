package com.aamir.dungeonarena.decorator;

public interface Combatant {
    String getName();
    int getHealth();
    int getMaxHealth();
    int getAttackPower();
    boolean isDefending();
    void setDefending(boolean defending);
    void setAttackPower(int attackPower);
    void takeDamage(int damage);
    void heal(int amount);
    boolean isAlive();
    int attack();
}