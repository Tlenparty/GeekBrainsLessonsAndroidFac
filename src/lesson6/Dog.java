package lesson6;

// Задние 1
public class Dog extends Animal {

    protected  int high;

    private static int dogCount = 0;

    public Dog(String name, int distance) {
        super(name, distance);
        dogCount++;
    }

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    boolean run(int distance) {
        if (distance <= (random.nextInt(200)+400)) {
            this.distance = distance;
        } else {
            System.err.printf("Собака %s столько не пробежит %n", name);
            return false;
        }
        System.out.printf("Собака %s пробежала %d метров %n", name, distance);
        return true;
    }

    @Override
    boolean swim(int distance) {
        if (distance <= 10) {
            this.distance = distance;
        } else {
            System.err.printf("Собака %s столько не проплывет", name);
            return false;
        }
        System.out.printf("Собака %s проплыла %d метров %n", name, distance);
        return true;
    }
    @Override
    boolean jump(int high) {
        if (high <= 0.5) {
            this.high = high;
        } else {
            System.err.printf("Собака %s столько не прыгнет %n", name);
            return false;
        }
        System.out.printf("Собака %s прыгунла %d метров %n", name, high);
        return  true;
    }


}
