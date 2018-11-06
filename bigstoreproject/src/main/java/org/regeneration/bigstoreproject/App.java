package org.regeneration.bigstoreproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(Constant.APP_CONFIG_LOCATION);

        Store flowerStore = context.getBean(FlowerStore.class);
        Store candyStore = context.getBean(CandyStore.class);


        System.out.println("Flowerstore has an item " + flowerStore.getItem());
        System.out.println("Candystore has an item " + candyStore.getItem());

    }

}