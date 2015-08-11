package kz.e16training.serialization.model;

import java.io.Serializable;

/**
 * Actor.
 *
 */
public class Actor implements Serializable{
    private String name;
    private String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
