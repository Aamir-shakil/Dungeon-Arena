package com.aamir.dungeonarena.observer;

public interface GameSubject {
    void addObserver(GameObserver observer);
    void removeObserver(GameObserver observer);
    void notifyObservers();
}