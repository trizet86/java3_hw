package com.java3.lesson_5;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(CARS_COUNT, new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

        race.awaitAllCars();
        try {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> На старт!!!");
            Thread.sleep(1000);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Внимание!!!");
            Thread.sleep(1000);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
        }
        race.start();

        race.awaitAllFinish();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}