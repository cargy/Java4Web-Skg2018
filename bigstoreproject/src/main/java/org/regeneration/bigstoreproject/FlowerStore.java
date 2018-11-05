package org.regeneration.bigstoreproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FlowerStore implements Store {


    @Autowired
    @Qualifier("flower")
    private Item item;

    public Item getItem()
    {
        return item;
    }




}
