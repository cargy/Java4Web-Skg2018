package org.regeneration.bigstoreproject;

import org.springframework.stereotype.Component;

@Component
public class Candy implements Item {

    public String getName() {
        return "Candy";
    }

    @Override
    public String toString() {
        return getName();
    }
}
