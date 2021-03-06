package com.java3.lesson_5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            race.carReadyToGo();
            race.awaitToStart();
        } catch (Exception e) {
            e.printStackTrace();
        }

        race.getStages().forEach(stage -> stage.go(this));

        race.carFinishTheRace();
        System.out.println(this.name + " ЗАКОНЧИЛ ГОНКУ!");
        if(race.carIsWinner()) {
            System.out.println(this.name + " WIN !");
        }
    }
}