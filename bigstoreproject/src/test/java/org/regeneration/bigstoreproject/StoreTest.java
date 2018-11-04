package org.regeneration.bigstoreproject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StoreTest {

    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    @Test
    public void test_candy_store() {
        Store candyStore = context.getBean("candyStore", Store.class);
        Store candy2Store = context.getBean("candyStore", Store.class);

        assertEquals(candyStore, candy2Store);
    }

    @Test
    public void test_flower_store() {
        Store flowerStore = context.getBean("flowerStore" , Store.class);
        Store flower2Store = context.getBean("flowerStore" , Store.class);

        assertNotEquals(flowerStore, flower2Store);
    }
}