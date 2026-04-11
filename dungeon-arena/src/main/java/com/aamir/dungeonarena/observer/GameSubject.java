package com.aamir.dungeonarena.observer;

/**
 * Subject interface for the Observer pattern.
 * Allows observers to register and receive updates.
 */
public interface GameSubject {

    /**
     * Registers an observer.
     */
    void addObserver(GameObserver observer);

    /**
     * Removes a registered observer.
     */
    void removeObserver(GameObserver observer);

    /**
     * Notifies all observers of a state change.
     */
    void notifyObservers();
}