package org.regeneration.bigstoreproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CandyStore implements Store {


    @Autowired
    @Qualifier("candy")
    private Item item;


    public Item getItem()
    {
        return item;
    }

}
