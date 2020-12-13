package lesson6;

public class Animal   {

    protected String name;
    protected int distance;

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


    void run(int distance){
        System.out.println("Животное побежало " + distance + "метров");
    }

    void swim(int distance){
        System.out.println("Животное проплыло " + distance + "метров");
    }

}
