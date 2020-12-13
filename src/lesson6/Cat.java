package lesson6;

public class Cat extends Animal {

    private static int catCount = 0;

    public Cat(String name, int distance){
        super(name, distance);
        catCount++;
    }

    public Cat(String name){
        super(name);
        catCount++;
    }

    public static int getCatCount(){
        return catCount;
    }


    @Override
    void run(int distance) {
        if (distance <= 200) {
            this.distance = distance;
        }else{
            System.err.println("Кот " + name + " столько не пробежит");

        }

        System.out.printf("Кот  %s пробежал  %d метров %n", name, distance);
    }

    @Override
    void swim(int distance) {
        System.err.printf("Кот %s не умеет плавать %n", name);
    }
}
