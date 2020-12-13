package lesson6;

public class Dog extends Animal {

    private static int dogCount = 0;

    public Dog(String name, int distance){
        super(name, distance);
        dogCount++;
    }

    public Dog(String name){
        super(name);
        dogCount++;
    }

    public static int getDogCount(){
        return dogCount;
    }

    @Override
    void run(int distance) {
        if (distance <= 500) {
            this.distance = distance;
        }else{
            System.err.printf("Собака %s столько не пробежит %n" , name);

        }
        System.out.printf("Собака %s пробежала %d метров %n", name, distance);
    }

    @Override
    void swim(int distance) {
        if (distance <= 10){
            this.distance = distance;
        }else {
            System.err.printf("Собака %s столько не проплывет" , name);
        }
        System.out.printf("Собака %s проплыла %d метров %n", name, distance);
    }
}
