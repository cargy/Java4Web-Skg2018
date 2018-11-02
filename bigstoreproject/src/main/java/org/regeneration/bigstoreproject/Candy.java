package org.regeneration.bigstoreproject;

public class Candy implements Item {

    public String getName() {
        return "Candy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
