package org.regeneration.bigstoreproject;

public class Flower implements  Item {

    public String getName() {
        return "Flower";
    }

    @Override
    public String toString() {
        return getName();
    }
}
