package org.regeneration.bigstoreproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Store flowerStore = context.getBean("flowerStore" , Store.class);

        Store candyStore = context.getBean("candyStore", Store.class);
        Store candy2Store = context.getBean("candyStore", Store.class);

        System.out.println("Compare candy stores " + candyStore.equals(candy2Store));

        System.out.println("Flower store has an item " + flowerStore.getItem());
        System.out.println("Candy store has an item " + candyStore.getItem());

    }
/*
    public static void main(String[] args) {
        Item candy = new Candy();
        Store candyStore = new Store(candy);

        Item flower = new Flower();
        Store flowerStore = new Store(flower);

        System.out.println("Flower store has an item " + flowerStore.getItem());
        System.out.println("Store store has an item " + candyStore.getItem());
    }
    */
}
