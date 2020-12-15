package lesson6;

import java.util.Random;

public class Animal   {

    protected String name;
    protected int distance;
    protected int high;

    Random random = new Random();


    public Animal(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Animal(String name){
        this(name,0);
    }
    public Animal(){
        this(null);
    }

    // Задание 2

    boolean run(int distance){
        System.out.println("Животное побежало " + distance + "метров");
        return true;
    }

    boolean swim(int distance){
        System.out.println("Животное проплыло " + distance + "метров");
        return true;
    }

    boolean jump(int high){
        System.out.println("Животное " + high +  "подпрыгнуло");
        return true;
    }
}

