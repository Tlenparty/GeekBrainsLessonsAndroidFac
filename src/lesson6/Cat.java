package lesson6;

// Задание 1
public class Cat extends Animal {

    private static int catCount = 0;

    public Cat(String name, int distance) {
        super(name, distance);
        catCount++;
    }

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }


    @Override
    public boolean run(int distance) {
        if (distance <= (random.nextInt(50)+150)) {
            this.distance = distance;
        } else {
            System.err.println("Кот " + name + " столько не пробежит");
            return false;
        }
        System.out.printf("Кот  %s пробежал  %d метров %n", name, distance);
        return true;
    }

    @Override
    boolean swim(int distance) {
        System.err.printf("Кот %s не умеет плавать %n", name);
        return false;
    }

    @Override
    boolean jump(int high) {
        if (high <= 2) {
            this.high = high;
        } else {
            System.err.printf("Кот %s столько не прыгнет %n", name);
            return false;
        }
        System.out.printf("Кот %s прыгнул %d метров %n", name, high);
        return true;
    }
}
