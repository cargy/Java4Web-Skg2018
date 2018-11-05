package org.regeneration.bigstoreproject;

import org.springframework.stereotype.Component;

@Component
public class Flower implements  Item {

    public String getName() {
        return "Flower";
    }

    @Override
    public String toString() {
        return getName();
    }
}
